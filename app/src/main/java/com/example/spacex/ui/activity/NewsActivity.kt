package com.example.spacex.ui.activity

import AllLaunchDetailsQuery
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.epoxy.EpoxyRecyclerView
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.exception.ApolloException
import com.example.spacex.R
import com.example.spacex.data.Entry
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
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
        showLottieAnimation()
        epoxyList = findViewById(R.id.epoxyList)


        val scope = CoroutineScope(Dispatchers.Main + Job())

        fetchDataFromServer(scope)
    }

    /**
     * Fetch data from server using apollo service
     *
     * @param scope
     */
    private fun fetchDataFromServer(scope: CoroutineScope) {
        scope.launch {
            val response = try {
                client.query(AllLaunchDetailsQuery()).toDeferred().await()
            } catch (e: ApolloException) {
                fetchDataFromServer(this)
                return@launch
            }

            val launches = response.data?.launches?.reversed()

            if (launches == null || response.hasErrors()) {
                // handle application errors
                return@launch
            } else {
                animation_view.pauseAnimation()
                animation_view.visibility = View.INVISIBLE
                loading_text.visibility = View.INVISIBLE
                falcon.visibility = View.VISIBLE
                epoxyList.withModels {
                    launches.forEach(fun(it: AllLaunchDetailsQuery.Launch?) {
                        Log.d("how many", ":${it} ")
                        entry {
                            id(hashCode())
                            name(it?.site)
                            date(it?.launch_date_utc.toString())
                            mission(it?.mission?.name)
                        }
                    })
                }
            }


        }
    }

    private fun showLottieAnimation() {

        animation_view.playAnimation()
    }


}


