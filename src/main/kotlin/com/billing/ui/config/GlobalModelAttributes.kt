package com.billing.ui.config

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute

@ControllerAdvice
class GlobalModelAttributes(
    private val uiProperties: UiProperties
) {

    @ModelAttribute("appName")
    fun appName() = uiProperties.appName

    @ModelAttribute("companyName")
    fun companyName() = uiProperties.companyName

    @ModelAttribute("appVersion")
    fun appVersion() = uiProperties.version
}