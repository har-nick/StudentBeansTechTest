package com.harnick.studentbeanstechtest.di

import android.content.Context
import coil.ImageLoader
import coil.disk.DiskCache
import coil.memory.MemoryCache
import com.harnick.studentbeanstechtest.photos.data.PlaceholderApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {
    @Provides
    @Singleton
    fun provideCoilImageLoader(
        @ApplicationContext appContext: Context
    ): ImageLoader {
        return ImageLoader(appContext)
            .newBuilder()
            .crossfade(300)
            .memoryCache {
                MemoryCache.Builder(appContext)
                    .maxSizePercent(0.40)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .maxSizePercent(0.02)
                    .build()
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideKtorClient(): HttpClient {
        return HttpClient(Android) {
            expectSuccess = true
            followRedirects = false

            install(ContentNegotiation) {
                json(Json)
            }
        }
    }

    @Provides
    @Singleton
    fun providePlaceholderApi(client: HttpClient): PlaceholderApi {
        return PlaceholderApi(client)
    }
}