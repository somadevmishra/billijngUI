package com.billing.ui.item.view

import com.billing.ui.item.dto.ItemResponse

data class ItemPage(
    val title: String = "Items",

    val icon: String = "bi-box-seam",

    val searchText: String? = null,

    val items: List<ItemResponse> = emptyList(),

    val totalRecords: Int = 0
)
