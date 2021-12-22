package com.ndt.apiscenery.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Scenery(
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("image")
    val image: String,
    @Expose
    @SerializedName("title")
    val title: String
)