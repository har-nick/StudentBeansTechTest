package com.harnick.studentbeanstechtest.photos.data.repository

import com.harnick.studentbeanstechtest.core.util.Resource
import com.harnick.studentbeanstechtest.photos.domain.model.Photo
import com.harnick.studentbeanstechtest.photos.domain.repository.PhotoRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakePhotoRepo : PhotoRepo {
    private val fakePhotos = buildList {
        (1 .. 5000).forEach { i ->
            val fakePhoto = Photo(
                thumbnailUrl = "https://example.org",
                title = i.toString(),
                url = "https://example.org"
            )

            this.add(fakePhoto)
        }
    }

    override suspend fun fetchPhotos(count: String?): Flow<Resource<out List<Photo>>> {
        return flow {
            println(fakePhotos)
            emit(Resource.Success(fakePhotos))
        }
    }
}