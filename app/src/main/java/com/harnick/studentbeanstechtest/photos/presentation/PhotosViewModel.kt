package com.harnick.studentbeanstechtest.photos.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harnick.studentbeanstechtest.core.util.Resource.*
import com.harnick.studentbeanstechtest.di.IoDispatcher
import com.harnick.studentbeanstechtest.photos.domain.repository.PhotoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher,
    private val repo: PhotoRepo
) : ViewModel() {
    private val _state = MutableStateFlow(PhotosState())
    val state = _state.asStateFlow()

    init {
        getPhotos()
    }

    fun getPhotos(count: String? = null) {
        viewModelScope.launch {
            repo.fetchPhotos(count)
                .flowOn(ioDispatcher)
                .onEach { emission ->
                    _state.value = when (emission) {
                        is Fetching, is Error -> state.value.copy(currentStatus = emission.message)
                        is Success -> state.value.copy(photoList = emission.returnedData.orEmpty())
                    }
                }
                .collect()
        }
    }
}