package com.billing.ui.service

import com.billing.ui.client.dto.category.CategoryDto
import com.billing.ui.view.category.CategoryFormView
import com.billing.ui.view.category.CategoryPageView

interface CategoryUiService {

    fun getCategoryPage(): CategoryPageView

    fun getCreateCategoryPage(): CategoryFormView

    fun createCategory(form: CategoryFormView): CategoryDto

    fun rebuildCreateCategoryPage(page: CategoryFormView): CategoryFormView
}