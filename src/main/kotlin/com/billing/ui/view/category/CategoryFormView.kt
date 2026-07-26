package com.billing.ui.view.category

import jakarta.validation.constraints.NotBlank

data class CategoryFormView(

    val title: String = "",

    val subtitle: String = "",

    val icon: String = "",

    val id: Long? = null,

    val code: String? = null,

    @field:NotBlank(message = "Category name is required")
    val name: String = "",

    val description: String = "",

    val active: Boolean = true,

    val editMode: Boolean = false

)
