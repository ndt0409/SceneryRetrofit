package com.ndt.apiscenery.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.xml.parsers.FactoryConfigurationError

object SceneryClient {
    private val retrofit = Retrofit.Builder().baseUrl("http://simple-node-app-nkd.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()
    operator fun invoke():SceneryService{
        return retrofit.create(SceneryService::class.java)
    }
}