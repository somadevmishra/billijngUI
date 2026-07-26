package com.billing.ui.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "billing")
class BillingApiProperties (val basrURL: String = "http://localhost:9081"){

}