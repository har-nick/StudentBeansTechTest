package com.harnick.studentbeanstechtest.photos.domain.repository

import com.harnick.studentbeanstechtest.core.util.Resource
import com.harnick.studentbeanstechtest.photos.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface PhotoRepo {
    suspend fun fetchPhotos(count: String?): Flow<Resource<out List<Photo>>>
}