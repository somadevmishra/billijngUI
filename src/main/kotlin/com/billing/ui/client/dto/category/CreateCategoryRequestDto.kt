package com.billing.ui.client.dto.category

data class CreateCategoryRequestDto(
    val name: String,

    val description: String?,

    val active: Boolean
)
