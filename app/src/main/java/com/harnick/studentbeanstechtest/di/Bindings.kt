package com.harnick.studentbeanstechtest.di

import com.harnick.studentbeanstechtest.photos.data.repository.PhotoRepoImpl
import com.harnick.studentbeanstechtest.photos.domain.repository.PhotoRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class Bindings {
    @Binds
    @Singleton
    abstract fun bindPhotoRepo(
        photoRepoImpl: PhotoRepoImpl
    ): PhotoRepo
}