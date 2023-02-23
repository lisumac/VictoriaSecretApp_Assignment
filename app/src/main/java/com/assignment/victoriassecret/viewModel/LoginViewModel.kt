package com.assignment.victoriassecret.viewModel

import androidx.lifecycle.ViewModel
import com.assignment.victoriassecret.data.repository.ProductListRepository
import com.assignment.victoriassecret.utills.FieldValidator.isStringContainNumber
import com.assignment.victoriassecret.utills.FieldValidator.isStringContainSpecialCharacter
import com.assignment.victoriassecret.utills.FieldValidator.isStringLowerAndUpperCase
import com.assignment.victoriassecret.utills.FieldValidator.isValidEmail
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel@Inject constructor() : ViewModel() {


    fun validateEmail(email: TextInputEditText, emailTextInputLayout: TextInputLayout): Boolean {
        if (email.text.toString().trim().isEmpty()) {
            emailTextInputLayout.error = "Please enter your email"
            email.requestFocus()
            return false
        } else if (!isValidEmail(email.text.toString())) {
            emailTextInputLayout.error = "Invalid Email!"
            email.requestFocus()
            return false
        } else {
            emailTextInputLayout.isErrorEnabled = false
        }
        return true
    }

    fun validatePassword(
        password: TextInputEditText,
        passwordTextInputLayout: TextInputLayout
    ): Boolean {
        if (password.text.toString().trim().isEmpty()) {
            passwordTextInputLayout.error = "Please enter your password"
            password.requestFocus()
            return false
        } else if (password.text.toString().length < 6) {
            passwordTextInputLayout.error = "password can't be less than 6"
            password.requestFocus()
            return false
        } else if (!isStringContainNumber(password.text.toString())) {
            passwordTextInputLayout.error = "Required at least 1 digit"
            password.requestFocus()
            return false
        } else if (!isStringLowerAndUpperCase(password.text.toString())) {
            passwordTextInputLayout.error =
                "Password must contain upper and lower case letters"
            password.requestFocus()
            return false
        } else if (!isStringContainSpecialCharacter(password.text.toString())) {
            passwordTextInputLayout.error = "1 special character required"
            password.requestFocus()
            return false
        } else {
            passwordTextInputLayout.isErrorEnabled = false
        }
        return true
    }

}