package com.assignment.victoriassecret.view.activity

import org.junit.jupiter.api.Assertions.*

internal class LoginActivityTest

@Test
fun `signUp function returns false when username is taken`(){
    val userName = "Peter"
    val password = "12345"
    val repeatPassword = "12345"
    assertThat(em).isFalse()
}