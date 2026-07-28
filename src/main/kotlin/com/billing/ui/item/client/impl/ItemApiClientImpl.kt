package com.billing.ui.item.client.impl

import com.billing.ui.item.client.ItemApiClient
import com.billing.ui.item.dto.ItemResponse
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class ItemApiClientImpl(
    private val billingRestClient: RestClient
):ItemApiClient {
    override fun findAll(): List<ItemResponse> {
        return billingRestClient.get()
            .uri(ITEM_API)
            .retrieve()
            .body(object : ParameterizedTypeReference<List<ItemResponse>>() {})
            ?: emptyList()
    }

    private companion object {
        const val ITEM_API = "/api/items"
    }
}