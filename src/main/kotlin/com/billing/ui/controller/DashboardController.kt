package com.billing.ui.controller


import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class DashboardController {

    @GetMapping("/")
    fun home(): String = "dashboard/home"

    @GetMapping("/dashboard")
    fun dashboard(): String = "dashboard/home"
}