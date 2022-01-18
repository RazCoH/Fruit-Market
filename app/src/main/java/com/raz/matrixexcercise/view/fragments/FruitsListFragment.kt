package com.raz.matrixexcercise.view.fragments

import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raz.matrixexcercise.R
import com.raz.matrixexcercise.adapters.FruitsAdapter
import com.raz.matrixexcercise.model.Fruit
import com.raz.matrixexcercise.view_model.FruitViewModelFactory
import com.raz.matrixexcercise.view_model.FruitsViewModel

class FruitsListFragment(private val onClickListeners: OnClickListeners?) : BaseFragment() {

    private val viewModelFactory = FruitViewModelFactory()
    private lateinit var fruitViewModel: FruitsViewModel
    private lateinit var rvFruits: RecyclerView
    private lateinit var fruitsList: List<Fruit>
    private lateinit var vProgress: ProgressBar

    override fun initViews(view: View) {
        fruitsList = ArrayList()
        rvFruits = view.findViewById(R.id.rvFruits)
        vProgress = view.findViewById(R.id.vProgress)
        initFruitsListObserver()
    }

    override fun initListeners() {

    }

    override fun initTexts() {

    }

    override fun getContent(): Int {
        return R.layout.fruits_list_fragment_layout
    }

    private fun initFruitsListObserver() {
        fruitViewModel =
            ViewModelProvider(requireActivity(), viewModelFactory)[FruitsViewModel::class.java]
        fruitViewModel.updateFruitsList(context)
        fruitViewModel.getFruitsResponse.observe(requireActivity(), Observer {
            dataUpdateLogic(it)
        })
    }

    private fun dataUpdateLogic(fruits: List<Fruit>) {
        fruitsList = fruits
        rvFruits.visibility = View.VISIBLE
        vProgress.visibility = View.GONE
        initFruitsAdapter()
    }

    private fun initFruitsAdapter() {
        val adapter = FruitsAdapter(fruitsList, object : FruitsAdapter.OnFruitSelectedListener {
            override fun onFruitSelected(item: Fruit) {
                onClickListeners?.onFruitSelected(item)
            }

        })
        rvFruits.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvFruits.adapter = adapter
    }

    interface OnClickListeners {
        fun onFruitSelected(fruit: Fruit)
    }
}