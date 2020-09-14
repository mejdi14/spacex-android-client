package com.example.spacex

import LaunchDetailsQuery
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.coroutines.toDeferred
import com.apollographql.apollo.exception.ApolloException
import kotlinx.android.synthetic.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class NewsActivity : AppCompatActivity() {
    private lateinit var client: ApolloClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        client = setUpApolloClient()
        val scope = CoroutineScope(Dispatchers.Main + Job())

        scope.launch {
            val response = try {
                client.query(LaunchDetailsQuery(id = "1")).toDeferred().await()
            } catch (e: ApolloException) {
                // handle protocol errors
                return@launch
            }

            val launch = response.data?.launch
            if (launch == null || response.hasErrors()) {
                // handle application errors
                return@launch
            }
            Log.d("lauches", "onCreate: " + launch)

            // launch now contains a typesafe model of your data
           // println("Launch site: ${launches.id}")
        }
    }

    private fun setUpApolloClient(): ApolloClient {
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


