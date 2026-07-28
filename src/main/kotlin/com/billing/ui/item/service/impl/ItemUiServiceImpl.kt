package com.billing.ui.item.service.impl

import com.billing.ui.item.client.ItemApiClient
import com.billing.ui.item.service.ItemUiService
import com.billing.ui.item.view.ItemPage
import org.springframework.stereotype.Service

@Service
class ItemUiServiceImpl(
    private val itemApiClient: ItemApiClient
): ItemUiService {
    override fun getItemPage(): ItemPage {
        val items = itemApiClient.findAll()

        return ItemPage(
            items = items,
            totalRecords = items.size
        )
    }
}