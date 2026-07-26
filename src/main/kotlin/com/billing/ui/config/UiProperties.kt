package com.billing.ui.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "ui")
data class UiProperties(

    val application: Application = Application(),

    val branding: Branding = Branding(),

    val icons: Icons = Icons(),

    val formatting: Formatting = Formatting(),

    val pagination: Pagination = Pagination()

) {

    data class Application(
        val name: String = "",
        val company: String = "",
        val version: String = ""
    )

    data class Branding(
        val logo: String = "",
        val favicon: String = ""
    )

    data class Icons(
        val dashboard: String = "",
        val category: String = "",
        val item: String = "",
        val bill: String = "",
        val report: String = "",
        val settings: String = ""
    )

    data class Formatting(
        val currencySymbol: String = "₹",
        val dateFormat: String = "dd-MMM-yyyy"
    )

    data class Pagination(
        val pageSize: Int = 20
    )
}