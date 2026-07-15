package com.billing.ui.view.category

import java.util.Collections.emptyList

data class CategoryPageView(
    val pageTitle: String,

    val searchText: String = "",

    val categories: List<CategoryView> = emptyList(),

    val totalRecords: Int = 0
)
