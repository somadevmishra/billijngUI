package com.billing.ui.config

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute

@ControllerAdvice
class GlobalModelAttributes(
    private val uiProperties: UiProperties
) {

    @ModelAttribute("appName")
    fun appName() = uiProperties.application.name

    @ModelAttribute("companyName")
    fun companyName() = uiProperties.application.company

    @ModelAttribute("appVersion")
    fun appVersion() = uiProperties.application.version
}