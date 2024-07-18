package com.example.route.route_task.ui.product.fragment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.route.domain.common.Resource
import com.example.route.domain.models.Product
import com.example.route.domain.usecase.GetProductUseCase
import com.example.route.route_task.base.ViewMessage
import com.example.route.route_task.utils.MainCoroutineRule
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class ProductsViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: ProductsViewModel
    private val getProductUseCase: GetProductUseCase = mockk()

    private val loadingObserver: Observer<Boolean> = mockk(relaxed = true)
    private val errorObserver: Observer<ViewMessage> = mockk(relaxed = true)
    private val productListObserver: Observer<List<Product>> = mockk(relaxed = true)

    @Before
    fun setUp() {
        viewModel = ProductsViewModel(getProductUseCase)
        viewModel.loadingLiveData.observeForever(loadingObserver)
        viewModel.errorMessage.observeForever(errorObserver)
        viewModel.productListLiveData.observeForever(productListObserver)
    }

    @Test
    fun `getAllProducts returns success`() = runBlocking {
        val productList = listOf(Product(title = ""))
        coEvery { getProductUseCase.getALlProduct() } returns Resource.Success(productList)

        viewModel.getAllProducts()

        verify { loadingObserver.onChanged(true) }
        verify { productListObserver.onChanged(productList) }
        verify { loadingObserver.onChanged(false) }
    }

    @Test
    fun `getAllProducts returns fail`() = runBlocking {
        val message = "Test Failed"
        coEvery { getProductUseCase.getALlProduct() } returns Resource.Fail(Exception(message))

        viewModel.getAllProducts()

        verify { loadingObserver.onChanged(true) }
        verify { errorObserver.onChanged(ViewMessage("Error", message)) }
        verify { loadingObserver.onChanged(false) }
    }

    @Test
    fun `getAllProducts returns loading`() = runBlocking {
        coEvery { getProductUseCase.getALlProduct() } returns Resource.Loading

        viewModel.getAllProducts()

        verify { loadingObserver.onChanged(true) }
    }
}
