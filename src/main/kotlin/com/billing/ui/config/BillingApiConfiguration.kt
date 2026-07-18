package com.billing.ui.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient

@Configuration
class BillingApiConfiguration {

    @Bean
    fun billingRestClient(
        @Value("\${billing.api.base-url}")
        baseUrl: String
    ): RestClient =
        RestClient.builder()
            .baseUrl(baseUrl)
            .build()
}