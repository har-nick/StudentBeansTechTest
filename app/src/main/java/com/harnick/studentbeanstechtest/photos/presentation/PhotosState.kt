package com.harnick.studentbeanstechtest.photos.presentation

import com.harnick.studentbeanstechtest.photos.domain.model.Photo

data class PhotosState(
    val currentStatus: String? = null,
    val errorList: List<String> = emptyList(),
    val isRefreshing: Boolean = false,
    val photoLimit: Int? = null,
    val photoList: List<Photo> = emptyList()
)
