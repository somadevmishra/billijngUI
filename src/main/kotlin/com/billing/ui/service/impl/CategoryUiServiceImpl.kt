package com.billing.ui.service.impl

import com.billing.ui.client.category.CategoryApiClient
import com.billing.ui.client.dto.category.CategoryDto
import com.billing.ui.client.dto.category.CreateCategoryRequestDto
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

        val categories = categoryApiClient.findAll()

        return CategoryPageView(

            title = "Categories",

            subtitle = "Manage product categories.",

            categories = categories.map {

                CategoryView(

                    code = it.code,

                    name = it.name,

                    description = it.description ?: "",

                    active = it.active

                )

            }

        )

    }

    override fun getCreateCategoryPage(): CategoryFormView {
        return CategoryFormView(
            title = "New Category",
            subtitle = "Create a new Category",
            icon = uiProperties.icons.category,
            active = true,
            editMode = false
        )
    }

    override fun createCategory(
        form: CategoryFormView
    ): CategoryDto {

        return categoryApiClient.create(

            CreateCategoryRequestDto(

                name = form.name,

                description = form.description,

                active = form.active

            )

        )

    }

    override fun rebuildCreateCategoryPage(
        page: CategoryFormView
    ): CategoryFormView =
        getCreateCategoryPage().copy(

            code = page.code,

            name = page.name,

            description = page.description,

            active = page.active

        )
}