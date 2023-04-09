package com.harnick.studentbeanstechtest.photos.data

import com.harnick.studentbeanstechtest.photos.data.remote.PhotoDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject

class PlaceholderApi @Inject constructor(
    private val client: HttpClient
) {
    private companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
        const val PHOTOS_URL = "$BASE_URL/photos"
    }

    suspend fun fetchPhotos(count: String? = null): List<PhotoDto> {
        val url = "$PHOTOS_URL/".plus(count.orEmpty())

        return client.get(url).body()
    }
}