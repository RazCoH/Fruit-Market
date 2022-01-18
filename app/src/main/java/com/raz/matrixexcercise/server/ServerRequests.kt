package com.raz.matrixexcercise.server

import com.raz.matrixexcercise.model.Fruit
import com.raz.matrixexcercise.model.FruitsList
import retrofit2.Call
import retrofit2.http.GET

interface ServerRequests {
    @GET("fruitsBT/getFruits")
    fun getFruit(): Call<FruitsList>
}
