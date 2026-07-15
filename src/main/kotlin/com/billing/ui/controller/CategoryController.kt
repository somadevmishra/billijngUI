package com.billing.ui.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/categories")
class CategoryController {

    @GetMapping
    fun list(model: Model): String {

        model.addAttribute("pageTitle", "Categories")
        return "category/list"
    }
}