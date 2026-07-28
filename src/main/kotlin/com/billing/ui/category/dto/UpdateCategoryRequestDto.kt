package com.billing.ui.category.dto

data class UpdateCategoryRequestDto (

    val name: String,

    val description: String?,

    val active: Boolean
)