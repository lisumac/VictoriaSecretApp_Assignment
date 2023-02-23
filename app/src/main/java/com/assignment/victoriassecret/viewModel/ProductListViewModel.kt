package com.assignment.victoriassecret.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.victoriassecret.data.dataModel.Product
import com.assignment.victoriassecret.data.dataModel.UserDetailsResponse
import com.assignment.victoriassecret.data.repository.ProductListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ProductListViewModel@Inject constructor(private val repository: ProductListRepository) : ViewModel() {



    val productsLiveData : LiveData<List<Product>>
        get() = repository.products

    init {
        viewModelScope.launch {

            repository.getProducts()
        }
    }


   /*  val productsLiveData = MutableLiveData<List<Product>>()
    val recipeResponse: LiveData<List<Product>>
        get() = productsLiveData
    private fun getProductList() = viewModelScope.launch {
        repository.getProduct().let { response ->

            if (response.isSuccessful) {
                productsLiveData.postValue(response.body()?.data?.products)
            } else {
                Log.d("response", "error: ${response.code()}")
            }
        }
    }*/
}