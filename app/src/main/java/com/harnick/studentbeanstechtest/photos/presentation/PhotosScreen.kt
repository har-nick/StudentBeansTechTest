package com.harnick.studentbeanstechtest.photos.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.harnick.studentbeanstechtest.core.presentation.components.SurfaceBackground
import com.harnick.studentbeanstechtest.photos.presentation.components.PhotoList
import com.harnick.studentbeanstechtest.photos.presentation.components.PhotosHeader
import com.harnick.studentbeanstechtest.photos.presentation.components.StatusNotifier
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun PhotosScreen(
    navigator: DestinationsNavigator,
    photosViewModel: PhotosViewModel = hiltViewModel()
) {
    val state by photosViewModel.state.collectAsStateWithLifecycle()

    SurfaceBackground {
        Column(
            Modifier
                .statusBarsPadding()
                .padding(10.dp, 0.dp)
        ) {
            PhotosHeader(navigator)

            Spacer(Modifier.height(10.dp))

            if (state.photoList.isEmpty()) {
                StatusNotifier(state.isRefreshing, state.currentStatus ?: "No photos are loaded!")
            } else {
                PhotoList(state.photoList)
            }
        }
    }
}