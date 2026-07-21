package com.billing.ui.client.dto.category

data class UpdateCategoryRequestDto (

    val name: String,

    val description: String?,

    val active: Boolean
)