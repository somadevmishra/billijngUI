package com.billing.ui.service.impl

import com.billing.ui.service.CategoryUiService
import com.billing.ui.view.category.CategoryPageView
import com.billing.ui.view.category.CategoryView
import org.springframework.stereotype.Service

@Service
class CategoryUiServiceImpl : CategoryUiService {
    override fun getCategoryPage(): CategoryPageView {

        val categories = listOf(

            CategoryView(
                code = "CAT001",
                name = "Beverages",
                description = "Tea & Coffee",
                displayOrder = 1,
                active = true
            ),

            CategoryView(
                code = "CAT002",
                name = "Snacks",
                description = "Fast Food",
                displayOrder = 2,
                active = true
            ),

            CategoryView(
                code = "CAT003",
                name = "Desserts",
                description = "Sweet Items",
                displayOrder = 3,
                active = false
            )

        )

        return CategoryPageView(

            pageTitle = "Categories",

            categories = categories,

            totalRecords = categories.size

        )
    }
}