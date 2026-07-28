package com.billing.ui.item.controller

import com.billing.ui.item.service.ItemUiService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/items")
class ItemController(
    private val itemUiService: ItemUiService
) {

    @GetMapping
    fun list(model: Model): String {
        model.addAttribute(
            "page",
            itemUiService.getItemPage()
        )
        return "item/list"
    }
}