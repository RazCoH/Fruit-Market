package com.raz.matrixexcercise.view.fragments

import android.app.Dialog
import android.graphics.Paint
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.raz.matrixexcercise.R
import com.raz.matrixexcercise.databinding.FruitPageFragmentBinding
import com.raz.matrixexcercise.model.Fruit


class FruitPageFragment(private val fruit: Fruit, private val onClickListeners: OnClickListeners?) :
    BaseFragment() {

    private lateinit var ivArrowBack: ImageView
    private lateinit var btnAddToCart: Button

    override fun initViews(view: View) {
        ivArrowBack = view.findViewById(R.id.ivArrowBack)
        btnAddToCart = view.findViewById(R.id.btnAddToCart)

        view.let {
            DataBindingUtil.bind<FruitPageFragmentBinding>(it).apply {
                this?.fruitItem = fruit
                this?.lifecycleOwner = activity
            }
        }
    }

    override fun initListeners() {
        ivArrowBack.setOnClickListener {
            onClickListeners?.onBack()
        }

        btnAddToCart.setOnClickListener {
            showAddToCartDialog()
        }
    }

    override fun initTexts() {

    }

    override fun getContent(): Int {
        return R.layout.fruit_page_fragment
    }

    private fun showAddToCartDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.add_to_cart_dialog)
        val ivClose = dialog.findViewById<ImageView>(R.id.ivClose)
        val tvGotIt = dialog.findViewById<TextView>(R.id.tvGotIt)
        tvGotIt.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        ivClose.setOnClickListener {
            dialog.dismiss()
        }
        tvGotIt.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }


    interface OnClickListeners {
        fun onBack()
    }
}