package com.harnick.studentbeanstechtest.photos.data.repository

import com.harnick.studentbeanstechtest.core.util.Resource
import com.harnick.studentbeanstechtest.photos.data.PlaceholderApi
import com.harnick.studentbeanstechtest.photos.domain.model.toPhoto
import com.harnick.studentbeanstechtest.photos.domain.repository.PhotoRepo
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PhotoRepoImpl @Inject constructor(
    private val api: PlaceholderApi
) : PhotoRepo {
    override suspend fun fetchPhotos(count: String?) = flow {
        emit(Resource.Fetching("Fetching photos..."))

        try {
            val mappedPhotos = api.fetchPhotos(count).map { it.toPhoto() }

            emit(Resource.Success(mappedPhotos))
        } catch (e: Exception) {
            emit(Resource.Error(null, e.message.toString()))
        }
    }
}