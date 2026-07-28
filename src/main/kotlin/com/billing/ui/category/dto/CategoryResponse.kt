package com.billing.ui.category.dto

data class CategoryResponse(

    val id: Long,

    val code: String,

    val name: String,

    val description: String?,

    val displayOrder: Int,

    val active: Boolean
)