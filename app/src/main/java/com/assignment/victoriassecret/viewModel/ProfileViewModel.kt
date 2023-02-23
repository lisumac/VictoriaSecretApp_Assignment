package com.assignment.victoriassecret.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.victoriassecret.data.dataModel.UserDetailsResponse
import com.assignment.victoriassecret.data.repository.ProductListRepository
import com.assignment.victoriassecret.data.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ProfileViewModel@Inject constructor(private val repository: ProfileRepository):ViewModel() {

    private val _profileDetails = MutableLiveData<UserDetailsResponse>()
    val userDetails: LiveData<UserDetailsResponse>
        get() = _profileDetails

    init {
        getProfileDetails()
    }

    private fun getProfileDetails() = viewModelScope.launch {
        repository.getProfile().let { response ->

            if (response.isSuccessful) {
                _profileDetails.postValue(response.body())
            } else {
                Log.d("response", "error: ${response.code()}")
            }
        }
    }

    }


