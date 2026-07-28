package com.billing.ui.item.client

import com.billing.ui.item.dto.ItemResponse

interface ItemApiClient {

    fun findAll(): List<ItemResponse>
}