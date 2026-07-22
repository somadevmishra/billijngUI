package com.billing.ui.service.impl

import com.billing.ui.client.category.CategoryApiClient
import com.billing.ui.client.dto.category.CategoryDto
import com.billing.ui.client.dto.category.CreateCategoryRequestDto
import com.billing.ui.client.dto.category.UpdateCategoryRequestDto
import com.billing.ui.config.UiProperties
import com.billing.ui.service.CategoryUiService
import com.billing.ui.view.category.CategoryFormView
import com.billing.ui.view.category.CategoryPageView
import com.billing.ui.view.category.CategoryView
import org.springframework.stereotype.Service

@Service
class CategoryUiServiceImpl(
    private val uiProperties: UiProperties,
    private val categoryApiClient: CategoryApiClient
) : CategoryUiService {
    override fun getCategoryPage(): CategoryPageView {

        return CategoryPageView(

            title = "Categories",

            subtitle = "Manage product categories.",

            icon = uiProperties.icons.category,

            categories = categoryApiClient.findAll()
                .map { category ->

                    CategoryView(

                        id = category.id,

                        code = category.code,

                        name = category.name,

                        description = category.description,

                        active = category.active

                    )

                }

        )

    }

    override fun getCreateCategoryPage(): CategoryFormView {

        return CategoryFormView(

            title = "New Category",

            subtitle = "Create a new category.",

            icon = uiProperties.icons.category,

            id = null,

            code = null,

            name = "",

            description = "",

            active = true,

            editMode = false

        )

    }

    override fun getEditCategoryPage(id: Long): CategoryFormView {

        val category = categoryApiClient.findById(id)

        return CategoryFormView(

            title = "Edit Category",

            subtitle = "Update category information.",

            icon = uiProperties.icons.category,

            id = category.id,

            code = category.code,

            name = category.name,

            description = category.description ?: "",

            active = category.active,

            editMode = true

        )
    }

    override fun rebuildCreateCategoryPage(
        page: CategoryFormView
    ): CategoryFormView {

        return getCreateCategoryPage().copy(

            code = page.code,
            name = page.name,
            description = page.description,
            active = page.active
        )
    }

    override fun rebuildEditCategoryPage(
        page: CategoryFormView
    ): CategoryFormView {
        val id = requireNotNull(page.id) {
            "Category id is required."
        }
        return getEditCategoryPage(id).copy(
            name = page.name,
            description = page.description,
            active = page.active
        )
    }

    override fun createCategory(
        page: CategoryFormView
    ): CategoryDto {
        return categoryApiClient.create(
            CreateCategoryRequestDto(
                name = page.name,
                description = page.description,
                active = page.active
            )
        )
    }

    override fun updateCategory(
        page: CategoryFormView
    ): CategoryDto {
        val id = requireNotNull(page.id) {
            "Category id is required."
        }
        return categoryApiClient.update(
            id,
            UpdateCategoryRequestDto(
                name = page.name,
                description = page.description,
                active = page.active
            )
        )
    }

    override fun deleteCategory(id: Long) {
        categoryApiClient.delete(id)
    }

}