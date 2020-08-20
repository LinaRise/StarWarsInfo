package com.nikak.linadom.starinfo.service

import android.content.Context
import com.nikak.linadom.starinfo.entity.Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
//    @GET("planets")
////    fun getAllPlanets(): Call<Model>

    @GET("planets")
    fun getAllPlanets(
    @Query("page") page:Int

    ): Call<Model>

    @GET("/planets/{id}")
    fun getPlanetById(@Path("id") id: Int): Call<Model>
}

