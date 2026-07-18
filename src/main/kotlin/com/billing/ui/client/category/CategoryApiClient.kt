package com.billing.ui.client.category

import com.billing.ui.client.dto.category.CategoryResponse

interface CategoryApiClient {

    fun findAll(): List<CategoryResponse>
}