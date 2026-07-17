package com.billing.ui.service

import com.billing.ui.view.category.CategoryFormView
import com.billing.ui.view.category.CategoryPageView

interface CategoryUiService {

    fun getCategoryPage(): CategoryPageView

    fun getCreateCategoryPage(): CategoryFormView
}