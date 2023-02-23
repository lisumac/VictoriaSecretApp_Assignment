package com.assignment.victoriassecret.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.assignment.victoriassecret.R
import com.assignment.victoriassecret.databinding.ActivityMainBinding
import com.assignment.victoriassecret.utills.InterfaceListener
import com.assignment.victoriassecret.utills.toast
import com.assignment.victoriassecret.viewModel.LoginViewModel
import com.assignment.victoriassecret.viewModel.ProductListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), InterfaceListener {
    lateinit var binding: ActivityMainBinding

    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        initDataBindingAndViewModel()
        setupListeners()
    }


    private fun setupListeners() {

        binding.email.addTextChangedListener(TextFieldValidation(binding.email))
        binding.password.addTextChangedListener(TextFieldValidation(binding.password))


    }

    private fun initDataBindingAndViewModel() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.loginVm = viewModel
        binding.handler = this


    }

    override fun btnOnClick() {
        if (viewModel.validateEmail(
                binding.email,
                binding.emailTextInputLayout
            ) && viewModel.validatePassword(binding.password, binding.passwordTextInputLayout)
        ) {
            goToDashBoard()
        }else{
            this.toast("Please enter proper login details")
        }
    }

    private fun goToDashBoard() {
        val intent = Intent(this, DashBoardActivity::class.java)
        startActivity(intent)
    }

    override fun forgotOnclick() {
        this.toast("Not implemented")
    }

    override fun showHidePassword() {

    }

    inner class TextFieldValidation(private val view: View) : TextWatcher {
        override fun afterTextChanged(s: Editable?) {}
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // checking ids of each text field and applying functions accordingly.
            when (view.id) {

                R.id.email -> {
                    viewModel.validateEmail(binding.email, binding.emailTextInputLayout)
                }
                R.id.password -> {
                    viewModel.validatePassword(binding.password, binding.passwordTextInputLayout)

                }

            }
        }
    }
}