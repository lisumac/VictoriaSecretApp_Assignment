package com.assignment.victoriassecret.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assignment.victoriassecret.data.repository.ProductListRepository
import javax.inject.Inject


/*
class LoginViewModelFactory(var mContext: Context) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(mContext) as T
    }

}

class DashBoardViewModelFactory(var mContext: Context) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DashBoardViewModel(mContext) as T
    }

}
*/



class ProductListViewModelFactory @Inject constructor(private val repository: ProductListRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductListViewModel(repository) as T
    }

}