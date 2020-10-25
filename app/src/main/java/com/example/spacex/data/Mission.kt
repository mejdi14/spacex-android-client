package com.example.spacex.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Mission {
    @SerializedName("__typename")
    @Expose
    private var typename: String? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("missionPatch")
    @Expose
    private var missionPatch: String? = null

    fun getTypename(): String? {
        return typename
    }

    fun setTypename(typename: String?) {
        this.typename = typename
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getMissionPatch(): String? {
        return missionPatch
    }

    fun setMissionPatch(missionPatch: String?) {
        this.missionPatch = missionPatch
    }
}