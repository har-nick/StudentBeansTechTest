package com.harnick.studentbeanstechtest.login.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.harnick.studentbeanstechtest.core.presentation.components.SurfaceBackground
import com.harnick.studentbeanstechtest.destinations.PhotosScreenDestination
import com.harnick.studentbeanstechtest.login.presentation.LoginEvent.NavigateToPhotos
import com.harnick.studentbeanstechtest.login.presentation.components.LoginButton
import com.harnick.studentbeanstechtest.login.presentation.components.LoginErrors
import com.harnick.studentbeanstechtest.login.presentation.components.LoginHeader
import com.harnick.studentbeanstechtest.login.presentation.components.LoginInput
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    val state by loginViewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(null) {
        loginViewModel.uiEvent.collect { event ->
            when (event) {
                is NavigateToPhotos -> navigator.navigate(PhotosScreenDestination)
            }
        }
    }

    SurfaceBackground {
        Column(
            Modifier
                .statusBarsPadding()
                .padding(40.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(80.dp))

            LoginHeader()

            Spacer(Modifier.height(60.dp))

            LoginInput(
                enabledState = !state.isVerifyingLogin,
                isPasswordField = false,
                placeholderText = "Email",
                textContentState = state.email.value,
                updateFieldEvent = loginViewModel::updateEmailInput
            )

            Spacer(Modifier.height(20.dp))

            LoginInput(
                enabledState = !state.isVerifyingLogin,
                isPasswordField = true,
                placeholderText = "Password",
                textContentState = state.password.value,
                updateFieldEvent = loginViewModel::updatePasswordInput
            )

            Spacer(Modifier.height(15.dp))

            LoginErrors(state.loginErrors)

            Spacer(Modifier.height(40.dp))

            LoginButton(
                enabledState = (state.loginErrors == null),
                isVerifyingLogin = state.isVerifyingLogin,
                submitEvent = loginViewModel::submitLoginDetails
            )
        }
    }
}