package com.raz.matrixexcercise.view.activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.raz.matrixexcercise.R
import com.raz.matrixexcercise.objects.FragmentsAndActivitiesNavigation
import java.util.*
import kotlin.concurrent.schedule

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private val delayTime = 3000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setDelayAndPushFruitsFragment()
    }

    private fun setDelayAndPushFruitsFragment() {
        Timer().schedule(delayTime) {
            FragmentsAndActivitiesNavigation.pushMainActivity(this@SplashScreenActivity)
            finish()
        }
    }
}