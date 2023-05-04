package com.kivous.draggerhiltretrofitapp.di

import com.kivous.draggerhiltretrofitapp.network.PostApiService
import com.kivous.draggerhiltretrofitapp.network.PostServiceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesBaseUrl(): String = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun providesRetrofitBuilder(baseUrl: String): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    fun providesPostApiService(retrofit: Retrofit): PostApiService =
        retrofit.create(PostApiService::class.java)
}