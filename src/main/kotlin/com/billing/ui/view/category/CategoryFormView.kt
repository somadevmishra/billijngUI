package com.billing.ui.view.category

data class CategoryFormView(

    val title: String,

    val subtitle: String,

    val icon: String,

    val code: String? = null,

    val name: String = "",

    val description: String = "",

    val active: Boolean = true,

    val editMode: Boolean = false

)
