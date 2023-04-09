package com.harnick.studentbeanstechtest.photos.presentation

import com.harnick.studentbeanstechtest.photos.data.repository.FakePhotoRepo
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class PhotosViewModelTest {
    private val dispatcher: CoroutineDispatcher = StandardTestDispatcher()
    private lateinit var photosViewModel: PhotosViewModel
    private lateinit var fakePhotoRepo: FakePhotoRepo

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
        fakePhotoRepo = FakePhotoRepo()
        photosViewModel = PhotosViewModel(dispatcher, fakePhotoRepo)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getPhotos value is added to state object`() {
        runTest {
            photosViewModel.getPhotos()
        }

        assert(photosViewModel.state.value.photoList.isNotEmpty())
    }
}