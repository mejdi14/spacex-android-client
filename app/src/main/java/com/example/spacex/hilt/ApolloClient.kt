package com.example.spacex.hilt

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton
@Module
@InstallIn(ApplicationComponent::class)
object ApolloClient {
    @Singleton
    @Provides
    fun provideApolloClient(): ApolloClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttp = OkHttpClient
            .Builder()
            .addInterceptor(logging)
        return ApolloClient.builder()
            .serverUrl("http://172.16.0.112:3000/graphql")
            .okHttpClient(okHttp.build()) //ApolloClient with okhttp
            .build()
    }

}