package com.harnick.studentbeanstechtest.photos.domain.model

import com.harnick.studentbeanstechtest.photos.data.remote.PhotoDto

data class Photo(
    val thumbnailUrl: String,
    val title: String,
    val url: String
)

fun PhotoDto.toPhoto(): Photo {
    return Photo(thumbnailUrl, title, url)
}
