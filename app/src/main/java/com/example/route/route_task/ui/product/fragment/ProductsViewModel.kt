package com.example.route.route_task.ui.product.fragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.route.domain.common.Resource
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
        loadingLiveData.value = true
        loadingLiveData.value = true
        viewModelScope.launch() {
            when (val result = getProductUseCase.getALlProduct()) {
                is Resource.Fail -> {
                    loadingLiveData.value = false
                    errorMessage.value = ViewMessage(
                        "Error", message = result.exception.localizedMessage
                    )
                }

                is Resource.Loading -> {
                    loadingLiveData.value = true
                }

                is Resource.Success -> {
                    productListLiveData.value = result.data
                    loadingLiveData.value = false
                }
            }
        }
    }
}


