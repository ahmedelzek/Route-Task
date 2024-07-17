package com.example.route.data.datasource.online

import com.example.route.data.api.WebService
import com.example.route.data.contract.ProductOnlineDataSource
import com.example.route.data.models.ProductResponse
import com.example.route.domain.common.Resource
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class ProductOnlineDataSourceImplTest {

    //Arrange
    private lateinit var productOnlineDataSource: ProductOnlineDataSource
    private lateinit var webService: WebService

    @Before
    fun setUp() {
        webService = mockk<WebService>()
        productOnlineDataSource = ProductOnlineDataSourceImpl(webService)
    }

    @Test
    fun `getAllProducts returns success when webservice return data`() = runBlocking {
        //Act
        val productResponse = ProductResponse(products = listOf())
        coEvery { webService.getAllProducts() } returns productResponse
        val result = productOnlineDataSource.getAllProduct()
        coVerify(atLeast = 1) { webService.getAllProducts() }

        //Assert
        assert(result is Resource.Success)
    }

    @Test
    fun `getAllProducts returns failure when webservice throw exception`() = runBlocking {

        val testMessage = "Test Failed"

        coEvery { webService.getAllProducts() } throws Exception(testMessage)

        val result = productOnlineDataSource.getAllProduct()

        coVerify(atLeast = 1) { webService.getAllProducts() }

        assert(result is Resource.Fail)
        val exception = (result as Resource.Fail).exception
        assertEquals(testMessage, exception.localizedMessage)
    }
}