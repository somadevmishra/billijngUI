package com.billing.ui.client.category

import com.billing.ui.client.dto.category.CategoryDto
import com.billing.ui.client.dto.category.CategoryResponse
import com.billing.ui.client.dto.category.CreateCategoryRequestDto

interface CategoryApiClient {

    fun findAll(): List<CategoryResponse>

    fun create(request: CreateCategoryRequestDto): CategoryDto
}