package com.ndt.apiscenery.network


import com.ndt.apiscenery.model.Scenery
import retrofit2.Call
import retrofit2.http.GET

interface SceneryService {
    @GET(".")
    fun getAllSecenery(): Call<List<Scenery>>
}