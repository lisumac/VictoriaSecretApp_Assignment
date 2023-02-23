package com.assignment.victoriassecret.viewModel

import com.assignment.victoriassecret.utills.FieldValidator
import com.assignment.victoriassecret.utills.Utils
import org.junit.Assert
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
internal class LoginViewModelTest {

    @Test
    fun validatePasswordTest() {
        val email = "lisgmail"
       // Assert.assertFalse("$email should be an invalid email", FieldValidator.(email))
    }

    @Test
    fun validateEmailTest(email: String) {
        val email = "lisa@gmail"
        Assert.assertFalse("$email should be an invalid email", FieldValidator.isValidEmail(email))
       // Assert.assertFalse("$email should be an invalid email", validator.isValid(email))
    }
}