package com.example.spacex.hilt

import com.apollographql.apollo.ApolloClient
import com.example.spacex.constant.constants.GRAPHQL_API_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApolloClient {

    @Singleton
    @Provides
    fun provideApolloClient(): ApolloClient {
        val logging = HttpLoggingClient.providesHttpLoggingClient()
        var okHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(logging)

        return ApolloClient.builder()
            .serverUrl(GRAPHQL_API_URL)
            .okHttpClient(okHttpClient.build())
            .build()
    }

}

