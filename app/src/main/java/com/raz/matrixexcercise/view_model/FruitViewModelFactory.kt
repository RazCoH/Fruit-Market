package com.raz.matrixexcercise.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FruitViewModelFactory :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FruitsViewModel() as T
    }
}