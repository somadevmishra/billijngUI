package com.billing.ui.category.service

import com.billing.ui.category.dto.CategoryDto
import com.billing.ui.category.view.CategoryFormView
import com.billing.ui.category.view.CategoryPageView

interface CategoryUiService {

    /**
     * Builds the Category List page.
     */
    fun getCategoryPage(): CategoryPageView

    /**
     * Builds the Create Category page.
     */
    fun getCreateCategoryPage(): CategoryFormView

    /**
     * Builds the Edit Category page.
     */
    fun getEditCategoryPage(id: Long): CategoryFormView

    /**
     * Rebuilds the Create page after validation errors.
     */
    fun rebuildCreateCategoryPage(
        page: CategoryFormView
    ): CategoryFormView

    /**
     * Rebuilds the Edit page after validation errors.
     */
    fun rebuildEditCategoryPage(
        page: CategoryFormView
    ): CategoryFormView

    /**
     * Creates a new category.
     */
    fun createCategory(
        page: CategoryFormView
    ): CategoryDto

    /**
     * Updates an existing category.
     */
    fun updateCategory(
        page: CategoryFormView
    ): CategoryDto

    fun deleteCategory(id: Long)
}