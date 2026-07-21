package com.billing.ui.client.category

import com.billing.ui.client.dto.category.CategoryDto
import com.billing.ui.client.dto.category.CategoryResponse
import com.billing.ui.client.dto.category.CreateCategoryRequestDto
import com.billing.ui.client.dto.category.UpdateCategoryRequestDto

interface CategoryApiClient {

    fun findAll(): List<CategoryDto>

    fun create(request: CreateCategoryRequestDto): CategoryDto

    fun findById(id: Long): CategoryDto

    fun update( id: Long, request: UpdateCategoryRequestDto): CategoryDto
}