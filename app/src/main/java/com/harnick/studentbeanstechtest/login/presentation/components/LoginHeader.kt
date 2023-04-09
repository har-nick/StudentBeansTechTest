package com.harnick.studentbeanstechtest.login.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun LoginHeader() {
    Text(
        "Welcome back",
        Modifier.fillMaxWidth(),
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.headlineLarge
    )
    Spacer(Modifier.height(10.dp))
    Text(
        "Log in to your Student Beans account",
        Modifier.fillMaxWidth(),
        style = MaterialTheme.typography.bodyLarge
    )
}