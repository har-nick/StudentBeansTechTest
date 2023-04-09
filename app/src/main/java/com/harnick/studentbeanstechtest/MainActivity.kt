package com.harnick.studentbeanstechtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.harnick.studentbeanstechtest.core.theme.StudentBeansTechTestTheme
import com.harnick.studentbeanstechtest.destinations.LoginScreenDestination
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StudentBeansTechTestTheme {
                DestinationsNavHost(NavGraphs.root, startRoute = LoginScreenDestination)
            }
        }
    }
}