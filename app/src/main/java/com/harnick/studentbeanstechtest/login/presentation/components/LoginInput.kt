package com.harnick.studentbeanstechtest.login.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginInput(
    enabledState: Boolean,
    isPasswordField: Boolean,
    placeholderText: String,
    textContentState: String,
    updateFieldEvent: (String) -> Unit,
) {
    OutlinedTextField(
        enabled = enabledState,
        modifier = Modifier
            .widthIn(0.dp, 400.dp)
            .fillMaxWidth(),
        onValueChange = { input -> updateFieldEvent(input) },
        placeholder = { Text(placeholderText, fontWeight = FontWeight.W500) },
        singleLine = true,
        value = textContentState,
        visualTransformation = if (isPasswordField) PasswordVisualTransformation() else VisualTransformation.None,
        shape = MaterialTheme.shapes.small
    )
}