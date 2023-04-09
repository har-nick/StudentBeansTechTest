package com.harnick.studentbeanstechtest.login.presentation

import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harnick.studentbeanstechtest.di.MainDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    @MainDispatcher
    private val mainDispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    private val _uiEvent = Channel<LoginEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        monitorDetails()
    }

    private fun sendEvent(event: LoginEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    fun updateEmailInput(input: String) {
        _state.value.email.value = input
    }

    fun updatePasswordInput(input: String) {
        _state.value.password.value = input
    }

    private fun monitorDetails() {
        val emailFlow = snapshotFlow { state.value.email.value }
        val passwordFlow = snapshotFlow { state.value.password.value }

        viewModelScope.launch(mainDispatcher) {
            emailFlow.combine(passwordFlow) { email, password ->
                val errorsFound = mutableListOf<String>()

                if (email.isBlank()) errorsFound.add("Your email must not be empty")
                if (password.isBlank()) errorsFound.add("Your password must not be empty")

                _state.value = state.value.copy(loginErrors = errorsFound.ifEmpty { null })
            }.collect()
        }
    }

    fun submitLoginDetails() {
        if (state.value.loginErrors == null) {
            sendEvent(LoginEvent.NavigateToPhotos)
        }
    }
}