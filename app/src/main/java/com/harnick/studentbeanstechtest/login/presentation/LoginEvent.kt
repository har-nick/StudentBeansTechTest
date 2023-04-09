package com.harnick.studentbeanstechtest.login.presentation

sealed interface LoginEvent {
    object NavigateToPhotos : LoginEvent
}