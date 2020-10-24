package com.example.spacex.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Links {

    @SerializedName("__typename")
    @Expose
    private var typename: String? = null

    @SerializedName("article_link")
    @Expose
    private var articleLink: String? = null

    @SerializedName("wikipedia")
    @Expose
    private var wikipedia: String? = null

    @SerializedName("youtube_id")
    @Expose
    private var youtubeId: String? = null

    fun getTypename(): String? {
        return typename
    }

    fun setTypename(typename: String?) {
        this.typename = typename
    }

    fun getArticleLink(): String? {
        return articleLink
    }

    fun setArticleLink(articleLink: String?) {
        this.articleLink = articleLink
    }

    fun getWikipedia(): String? {
        return wikipedia
    }

    fun setWikipedia(wikipedia: String?) {
        this.wikipedia = wikipedia
    }

    fun getYoutubeId(): String? {
        return youtubeId
    }

    fun setYoutubeId(youtubeId: String?) {
        this.youtubeId = youtubeId
    }
}