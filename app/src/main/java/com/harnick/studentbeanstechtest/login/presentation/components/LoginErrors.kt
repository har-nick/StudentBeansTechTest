package com.harnick.studentbeanstechtest.login.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LoginErrors(
    errorState: List<String>?,
) {
    errorState?.forEach { error ->
        Text(error, color = Color.Red)

        if (errorState.lastIndexOf(error) != errorState.size) {
            Spacer(Modifier.height(2.dp))
        }
    }
}