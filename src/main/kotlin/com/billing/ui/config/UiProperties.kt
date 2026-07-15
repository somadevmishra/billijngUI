package com.billing.ui.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "ui")
data class UiProperties(
    val appName: String = "CafeBilling",
    val companyName: String = "ABC Cafe Company",
    val version: String = "1.0.0",
    val currencySymbol: String = "₹",
    val pageSize: Int = 20,
    val dateFormat: String = "dd-MMM-yyyy"
)
