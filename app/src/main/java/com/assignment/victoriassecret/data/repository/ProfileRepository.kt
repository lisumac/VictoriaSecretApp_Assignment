package com.assignment.victoriassecret.data.repository

import com.assignment.victoriassecret.data.retrofit.ApiService
import javax.inject.Inject

class ProfileRepository
@Inject constructor(private val apiService: ApiService) {

    suspend fun getProfile() = apiService.getUserProfileDetails()

}
