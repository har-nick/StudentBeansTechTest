package com.harnick.studentbeanstechtest.photos.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.harnick.studentbeanstechtest.photos.domain.model.Photo

@Composable
fun PhotoEntry(photo: Photo) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        AsyncImage(
            model = photo.thumbnailUrl,
            contentDescription = "A placeholder image",
            Modifier
                .aspectRatio(1f)
                .fillMaxHeight()
                .clip(MaterialTheme.shapes.small)
        )

        Text(
            photo.title,
            Modifier
                .align(Alignment.CenterVertically)
                .padding(10.dp, 0.dp),
            maxLines = 2,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}