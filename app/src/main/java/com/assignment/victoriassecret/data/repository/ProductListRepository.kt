package com.assignment.victoriassecret.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.assignment.victoriassecret.data.dataModel.Product
import com.assignment.victoriassecret.data.retrofit.ApiService
import javax.inject.Inject

class ProductListRepository @Inject constructor(private val apiService: ApiService) {

    private val _products = MutableLiveData<List<Product>>()
    private val error = MutableLiveData<String>()
    val products: LiveData<List<Product>>
        get() = _products

    suspend fun getProducts() {
        val result = apiService.getProductList()
        if (result.isSuccessful && result.body() != null) {

            _products.postValue(result.body()!!.data.products)
        }else
        {
            error.postValue(result.errorBody().toString())
        }
    }
    //suspend fun getProduct() = apiService.getProductList()
}