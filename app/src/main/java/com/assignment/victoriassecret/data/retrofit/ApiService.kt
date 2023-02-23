package com.assignment.victoriassecret.data.retrofit

import com.assignment.victoriassecret.data.dataModel.ProductListResponse
import com.assignment.victoriassecret.data.dataModel.UserDetailsResponse
import com.assignment.victoriassecret.utills.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.productEndPoint)
   suspend fun  getProductList():Response<ProductListResponse>

   @GET(Constants.profileEndPoint)
   suspend fun getUserProfileDetails():Response<UserDetailsResponse>

}