package com.billing.ui.controller

import com.billing.ui.service.CategoryUiService
import com.billing.ui.view.category.CategoryFormView
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.mvc.support.RedirectAttributes

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

    @PostMapping
    fun createCategory(
        @Valid
        @ModelAttribute("page") page: CategoryFormView,
        bindingResult: BindingResult,
        model: Model,
        redirectAttributes: RedirectAttributes
    ): String {

        if (bindingResult.hasErrors()) {

            model.addAttribute(
                "page",
                categoryUiService.rebuildCreateCategoryPage(page)
            )

            return "category/form"
        }

        val category = categoryUiService.createCategory(page)

        redirectAttributes.addFlashAttribute(
            "successMessage",
            "Category '${category.name}' (${category.code}) created successfully."
        )

        return "redirect:/categories"
    }
}