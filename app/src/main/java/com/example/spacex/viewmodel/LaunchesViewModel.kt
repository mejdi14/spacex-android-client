package com.example.spacex.viewmodel

import androidx.lifecycle.ViewModel
import com.example.spacex.repository.LaunchesRespository

class LaunchesViewModel : ViewModel(){
    var launchesRespository : LaunchesRespository? = null

    init {
        launchesRespository = LaunchesRespository()
    }
}