package com.billing.ui.category.view

import java.util.Collections.emptyList

data class CategoryPageView(
    val title: String,

    val subtitle: String,

    val icon: String,

    val searchText: String = "",

    val categories: List<CategoryView> = emptyList(),

    val totalRecords: Int = 0
)
