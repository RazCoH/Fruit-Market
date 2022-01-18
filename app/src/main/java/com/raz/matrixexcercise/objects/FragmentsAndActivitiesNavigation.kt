package com.raz.matrixexcercise.objects

import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.raz.matrixexcercise.R
import com.raz.matrixexcercise.model.Fruit
import com.raz.matrixexcercise.view.activities.MainActivity
import com.raz.matrixexcercise.view.fragments.BaseFragment
import com.raz.matrixexcercise.view.fragments.FruitPageFragment
import com.raz.matrixexcercise.view.fragments.FruitsListFragment

object FragmentsAndActivitiesNavigation {


    fun pushMainActivity(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }

    fun pushFruitListFragment(activity: FragmentActivity) {
        val fruitListFragment = FruitsListFragment(object : FruitsListFragment.OnClickListeners {
            override fun onFruitSelected(fruit: Fruit) {
                pushFruitPageFragment(fruit, activity)
            }
        })
        activity.supportFragmentManager.beginTransaction()
            .addToBackStack(fruitListFragment.javaClass.name)
            .setCustomAnimations(R.anim.enter_from_left_anim, R.anim.exit_to_right_anim)
            .replace(R.id.fragments_container, fruitListFragment)
            .commit()
    }

    fun pushFruitPageFragment(fruit: Fruit, activity: FragmentActivity) {
        val fruitPageFragment =
            FruitPageFragment(fruit, object : FruitPageFragment.OnClickListeners {
                override fun onBack() {
                    activity.supportFragmentManager.popBackStackImmediate()
                }
            })

        activity.supportFragmentManager.beginTransaction()
            .addToBackStack(fruitPageFragment.javaClass.name)
            .setCustomAnimations(R.anim.enter_from_left_anim, R.anim.exit_to_right_anim)
            .add(R.id.fragments_container, fruitPageFragment)
            .commit()
    }
}