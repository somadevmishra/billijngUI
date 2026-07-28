package com.billing.ui.category.controller

import com.billing.ui.category.service.CategoryUiService
import com.billing.ui.category.view.CategoryFormView
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
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

    @PostMapping("/{id}")
    fun updateCategory(

        @PathVariable id: Long,

        @Valid
        @ModelAttribute("page")
        page: CategoryFormView,
        bindingResult: BindingResult,
        model: Model,
        redirectAttributes: RedirectAttributes
    ): String {

        if (bindingResult.hasErrors()) {
            model.addAttribute(
                "page",
                categoryUiService.rebuildEditCategoryPage(
                    page.copy(id = id)
                )
            )
            return "category/form"
        }

        val category = categoryUiService.updateCategory(
            page.copy(id = id)
        )
        redirectAttributes.addFlashAttribute(
            "successMessage",
            "Category '${category.name}' (${category.code}) updated successfully."
        )
        return "redirect:/categories"
    }

    @GetMapping("/{id}/edit")
    fun showEditForm(
        @PathVariable id: Long,
        model: Model
    ): String {

        model.addAttribute(
            "page",
            categoryUiService.getEditCategoryPage(id)
        )

        return "category/form"
    }

    @PostMapping("/{id}/delete")
    fun deleteCategory(
        @PathVariable id: Long,
        redirectAttributes: RedirectAttributes
    ): String {
        categoryUiService.deleteCategory(id)
        redirectAttributes.addFlashAttribute(
            "successMessage",
            "Category deleted successfully."
        )
        return "redirect:/categories"
    }
}