package com.harnick.studentbeanstechtest.photos.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.harnick.studentbeanstechtest.R
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun PhotosHeader(
    navigator: DestinationsNavigator
) {
    Row(
        Modifier.height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(Modifier.weight(0.3F)) {
            IconButton(
                onClick = { navigator.navigateUp() }
            ) {
                Icon(painterResource(R.drawable.ic_back_arrow), "Return to the login page")
            }
        }

        Box(Modifier.weight(0.3F)) {
            Text("Photos", Modifier.align(Alignment.Center), style = MaterialTheme.typography.titleLarge)

        }

        Box(Modifier.weight(0.3F))
    }
}