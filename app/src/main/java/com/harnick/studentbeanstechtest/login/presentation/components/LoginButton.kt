package com.harnick.studentbeanstechtest.login.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

@Composable
fun LoginButton(
    enabledState: Boolean,
    isVerifyingLogin: Boolean,
    submitEvent: () -> Unit
) {
    Button(
        contentPadding = PaddingValues(0.dp, 15.dp),
        enabled = enabledState,
        modifier = Modifier
            .testTag("LoginButton")
            .widthIn(0.dp, 400.dp)
            .fillMaxWidth(),
        onClick = submitEvent,
        shape = MaterialTheme.shapes.small
    ) {
        if (isVerifyingLogin) {
            CircularProgressIndicator()
        } else {
            Text(
                "Log In",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White
            )
        }
    }
}