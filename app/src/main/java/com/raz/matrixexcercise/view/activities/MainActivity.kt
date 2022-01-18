package com.raz.matrixexcercise.view.activities

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.raz.matrixexcercise.R
import com.raz.matrixexcercise.objects.FragmentsAndActivitiesNavigation

class MainActivity : FragmentActivity() {

    private var pressedTime:Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FragmentsAndActivitiesNavigation.pushFruitListFragment(this)
    }

    override fun onBackPressed() {
        if (this.supportFragmentManager.backStackEntryCount == 1) {
            if (pressedTime + 4000 > System.currentTimeMillis()) {
                super.onBackPressed()
                finish()
            } else {
                Toast.makeText(this, R.string.double_back_press_text, Toast.LENGTH_SHORT).show();
            }
            pressedTime = System.currentTimeMillis()
        }else{
            super.onBackPressed()
        }
    }
}