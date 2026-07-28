package com.billing.ui.category.client.impl

import com.billing.ui.category.client.CategoryApiClient
import com.billing.ui.category.dto.CategoryDto
import com.billing.ui.category.dto.CreateCategoryRequestDto
import com.billing.ui.category.dto.UpdateCategoryRequestDto
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import java.util.Collections.emptyList

@Component
class CategoryApiClientImpl(

    private val billingRestClient: RestClient

) : CategoryApiClient {

    override fun findAll(): List<CategoryDto> {

        return billingRestClient
            .get()
            .uri(CATEGORY_API)
            .retrieve()
            .body(object : ParameterizedTypeReference<List<CategoryDto>>() {})
            ?: emptyList()
    }

    override fun create(request: CreateCategoryRequestDto): CategoryDto {
        return billingRestClient
            .post()
            .uri("$CATEGORY_API")
            .body(request)
            .retrieve()
            .body(CategoryDto::class.java)
            ?: throw IllegalStateException("Category API returned an empty response.")
    }

    override fun findById(id: Long): CategoryDto {

        return billingRestClient
            .get()
            .uri("$CATEGORY_API/{id}", id)
            .retrieve()
            .body(CategoryDto::class.java)
            ?: throw IllegalStateException("Category not found.")
    }

    override fun update(
        id: Long,
        request: UpdateCategoryRequestDto
    ): CategoryDto {

        return billingRestClient
            .put()
            .uri("$CATEGORY_API/{id}", id)
            .body(request)
            .retrieve()
            .body(CategoryDto::class.java)
            ?: throw IllegalStateException(
                "Category API returned an empty response while updating category."
            )
    }

    override fun delete(id: Long) {
        billingRestClient.delete()
            .uri("$CATEGORY_API/{id}", id)
            .retrieve()
            .toBodilessEntity()
    }

    private companion object {
        const val CATEGORY_API = "/api/categories"
    }
}