package com.billing.ui.item.dto

import com.billing.ui.category.dto.CategoryResponse
import java.math.BigDecimal

data class ItemResponse(
    val id: Long,

    val code: String,

    val name: String,

    val description: String? = null,

    val category: CategoryResponse?,

    val unitPrice: BigDecimal,

    val gstPercentage: BigDecimal,

    val active: Boolean
)
