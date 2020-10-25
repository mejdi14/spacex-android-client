package com.example.spacex.ui.activity

import AllLaunchDetailsQuery
import LaunchDetailsQuery
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyRecyclerView
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred
import com.apollographql.apollo.exception.ApolloException
import com.example.spacex.MyApplication
import com.example.spacex.R
import com.example.spacex.data.Entry
import com.example.spacex.data.Launch
import com.example.spacex.epoxy.entry
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.ArrayList
import java.util.Map.entry
import javax.inject.Inject

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {
    private var entries = mutableListOf<Entry>(Entry("mejdi"), Entry("aymen"))

    @Inject
    lateinit var client: ApolloClient
    lateinit var epoxyList: EpoxyRecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        epoxyList = findViewById(R.id.epoxyList)


        val scope = CoroutineScope(Dispatchers.Main + Job())

        scope.launch {
            val response = try {
                client.query(AllLaunchDetailsQuery()).toDeferred().await()
            } catch (e: ApolloException) {
                // handle protocol errors
                return@launch
            }

            val launches = response.data?.launches
            if (launches == null || response.hasErrors()) {
                // handle application errors
                return@launch
            } else {
                epoxyList.withModels {
                    launches.forEach(fun(it: AllLaunchDetailsQuery.Launch?) {
                        Log.d("how many", ":${it} ")
                        entry {
                            id(hashCode())
                            name(it?.site)
                            date(it?.launch_year)
                            imageUrl(it?.mission?.missionPatch)
                            mission(it?.mission?.name)
                        }
                    })
                }
            }


            // launch now contains a typesafe model of your data
            // println("Launch site: ${launches.id}")
        }
    }


}


