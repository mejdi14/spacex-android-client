package com.example.spacex.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Launch {
    @SerializedName("__typename")
    @Expose
    private var typename: String? = null

    @SerializedName("id")
    @Expose
    private var id: String? = null

    @SerializedName("site")
    @Expose
    private var site: String? = null

    @SerializedName("mission")
    @Expose
    private var mission: Mission? = null

    @SerializedName("links")
    @Expose
    private var links: Links? = null

    fun getTypename(): String? {
        return typename
    }

    fun setTypename(typename: String?) {
        this.typename = typename
    }

    fun getId(): String? {
        return id
    }

    fun setId(id: String?) {
        this.id = id
    }

    fun getSite(): String? {
        return site
    }

    fun setSite(site: String?) {
        this.site = site
    }

    fun getMission(): Mission? {
        return mission
    }

    fun setMission(mission: Mission?) {
        this.mission = mission
    }

    fun getLinks(): Links? {
        return links
    }

    fun setLinks(links: Links?) {
        this.links = links
    }

    override fun toString(): String {
        return "Launch(typename=$typename, id=$id, site=$site, mission=$mission, links=$links)"
    }


}