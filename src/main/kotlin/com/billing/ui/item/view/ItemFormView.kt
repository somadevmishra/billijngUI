package com.billing.ui.item.view

import java.math.BigDecimal

data class ItemFormView(
    val id: Long? = null,

    val name: String = "",

    val description: String? = null,

    val categoryCode: String = "",

    val unitPrice: BigDecimal? = null,

    val gstPercentage: BigDecimal? = null,

    val active: Boolean = true
)
