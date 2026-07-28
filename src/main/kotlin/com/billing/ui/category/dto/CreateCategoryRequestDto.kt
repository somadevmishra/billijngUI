package com.billing.ui.category.dto

data class CreateCategoryRequestDto(
    val name: String,

    val description: String?,

    val active: Boolean
)
