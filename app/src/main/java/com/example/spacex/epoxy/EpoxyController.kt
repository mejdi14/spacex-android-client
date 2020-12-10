package com.example.spacex.epoxy

import com.airbnb.epoxy.AutoModel
import com.airbnb.epoxy.Typed2EpoxyController


class SampleController : Typed2EpoxyController<List<String>, Boolean>() {
    override fun buildModels(photos: List<String>, loadingMore: Boolean) {


    }
}