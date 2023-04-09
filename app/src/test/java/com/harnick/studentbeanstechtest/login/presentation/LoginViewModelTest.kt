package com.harnick.studentbeanstechtest.login.presentation

import kotlinx.coroutines.*
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {
    private val dispatcher: CoroutineDispatcher = StandardTestDispatcher()
    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        loginViewModel = LoginViewModel(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `update email input affects state value`() {
        runTest {
            loginViewModel.updateEmailInput("test value")
        }

        assert(loginViewModel.state.value.email.value == "test value")
    }

    @Test
    fun `update password input affects state value`() {
        runTest {
            loginViewModel.updatePasswordInput("test value")
        }

        assert(loginViewModel.state.value.password.value == "test value")
    }
}