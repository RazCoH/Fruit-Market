package com.raz.matrixexcercise.view_model

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raz.matrixexcercise.R
import com.raz.matrixexcercise.model.Fruit
import com.raz.matrixexcercise.model.FruitsList
import com.raz.matrixexcercise.server.RetrofitInstance
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FruitsViewModel : ViewModel() {

    val getFruitsResponse: MutableLiveData<List<Fruit>> = MutableLiveData()

    fun updateFruitsList(context: Context?) {
        viewModelScope.launch {
            val getFruits = RetrofitInstance.getServerRequests.getFruit()
            getFruits.enqueue(object : Callback<FruitsList> {
                override fun onResponse(call: Call<FruitsList>, response: Response<FruitsList>) {
                    if (response.isSuccessful) {
                        getFruitsResponse.value = response.body()?.fruits
                    }
                }

                override fun onFailure(call: Call<FruitsList>, t: Throwable) {
                    Toast.makeText(context, R.string.load_fruits_error, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

}