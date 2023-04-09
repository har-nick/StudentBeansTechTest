package com.harnick.studentbeanstechtest.login.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class LoginState(
    val email: MutableState<String> = mutableStateOf(""),
    val isVerifyingLogin: Boolean = false,
    val loginErrors: List<String>? = null,
    val password: MutableState<String> = mutableStateOf(""),
)
