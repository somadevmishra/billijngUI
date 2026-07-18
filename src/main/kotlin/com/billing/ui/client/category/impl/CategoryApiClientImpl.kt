package com.billing.ui.client.category.impl

import com.billing.ui.client.category.CategoryApiClient
import com.billing.ui.client.dto.category.CategoryDto
import com.billing.ui.client.dto.category.CategoryResponse
import com.billing.ui.client.dto.category.CreateCategoryRequestDto
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import java.util.Collections.emptyList

@Component
class CategoryApiClientImpl(

    private val billingRestClient: RestClient

) : CategoryApiClient {

    override fun findAll(): List<CategoryResponse> {

        return billingRestClient
            .get()
            .uri("api/categories")
            .retrieve()
            .body(object : ParameterizedTypeReference<List<CategoryResponse>>() {})
            ?: emptyList()

    }

    override fun create(request: CreateCategoryRequestDto): CategoryDto {
        return billingRestClient
            .post()
            .uri("/api/categories")
            .body(request)
            .retrieve()
            .body(CategoryDto::class.java)
            ?: throw IllegalStateException("Category API returned an empty response.")
    }

}