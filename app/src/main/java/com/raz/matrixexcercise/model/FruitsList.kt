package com.raz.matrixexcercise.model

import com.google.gson.annotations.SerializedName

data class FruitsList(@SerializedName("fruits") var fruits : List<Fruit>) {
}