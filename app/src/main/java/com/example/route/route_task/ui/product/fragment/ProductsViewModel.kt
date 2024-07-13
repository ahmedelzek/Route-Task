package com.example.route.route_task.ui.product.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.route.domain.models.Product
import com.example.route.domain.usecase.GetProductUseCase
import com.example.route.route_task.base.ViewMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductsViewModel @Inject
constructor(
    private val getProductUseCase: GetProductUseCase
) : ViewModel() {
    var loadingLiveData = MutableLiveData<Boolean>()
    var errorMessage = MutableLiveData<ViewMessage>()
    var productListLiveData = MutableLiveData<List<Product>>()
    fun getAllProducts() {
        try {
            loadingLiveData.value = true
            viewModelScope.launch {
                val listOfProduct = getProductUseCase.getALlProduct()
                productListLiveData.postValue(listOfProduct)
                loadingLiveData.value = false
            }
        } catch (e: Exception) {
            loadingLiveData.value = false
            errorMessage.value = ViewMessage(
                title = "Error",
                message = e.localizedMessage,
            )
        }
    }
}