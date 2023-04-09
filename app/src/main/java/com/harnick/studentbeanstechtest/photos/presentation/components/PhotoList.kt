package com.harnick.studentbeanstechtest.photos.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.harnick.studentbeanstechtest.photos.domain.model.Photo

@Composable
fun PhotoList(list: List<Photo>) {
    LazyColumn {
        items(list) { photo ->
            PhotoEntry(photo)
            
            if (list.indexOf(photo) != list.size) {
                Spacer(Modifier.height(10.dp))
            }
        }
    }
}