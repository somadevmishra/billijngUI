package com.billing.ui.category.client

import com.billing.ui.category.dto.CategoryDto
import com.billing.ui.category.dto.CreateCategoryRequestDto
import com.billing.ui.category.dto.UpdateCategoryRequestDto

interface CategoryApiClient {

    fun findAll(): List<CategoryDto>

    fun create(request: CreateCategoryRequestDto): CategoryDto

    fun findById(id: Long): CategoryDto

    fun update(id: Long, request: UpdateCategoryRequestDto): CategoryDto

    fun delete(id: Long)
}