package com.example.minerva.di

import com.example.minerva.core.Constants
import com.example.minerva.data.remote.ArtworkAICApi
import com.example.minerva.data.repository.ArtworkRepositoryImpl
import com.example.minerva.domain.repository.ArtworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAICApi() : ArtworkAICApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ArtworkAICApi::class.java)
    }

    @Provides
    @Singleton
    fun provideArtworkRepository(api: ArtworkAICApi): ArtworkRepository {
        return ArtworkRepositoryImpl(api)
    }
}