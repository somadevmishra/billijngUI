package com.billing.ui.controller

import com.billing.ui.service.CategoryUiService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/categories")
class CategoryController(
    private val categoryUiService: CategoryUiService

) {

    @GetMapping
    fun list(model: Model): String {
        model.addAttribute("page", categoryUiService.getCategoryPage())
        return "category/list"
    }

    @GetMapping("/new")
    fun showCreateForm(model: Model): String {

        model.addAttribute(
            "page",
            categoryUiService.getCreateCategoryPage()
        )

        return "category/form"
    }
}