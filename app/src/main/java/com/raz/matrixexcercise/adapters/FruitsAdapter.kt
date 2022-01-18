package com.raz.matrixexcercise.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raz.matrixexcercise.databinding.FruitCellLayoutBinding
import com.raz.matrixexcercise.model.Fruit

class FruitsAdapter(private val fruitList: List<Fruit>,private val listener:OnFruitSelectedListener) :
    RecyclerView.Adapter<FruitsAdapter.FruitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val fruitsListBinding = FruitCellLayoutBinding.inflate(inflater, parent, false)
        return FruitViewHolder(fruitsListBinding)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        holder.bindData(fruitList[position])
        holder.itemView.setOnClickListener {
            listener.onFruitSelected(fruitList[position])
        }
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

    inner class FruitViewHolder(private val binding: FruitCellLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(fruit: Fruit) {
            binding.fruitItem = fruit

        }
    }

    interface OnFruitSelectedListener{
        fun onFruitSelected(item:Fruit)
    }
}


