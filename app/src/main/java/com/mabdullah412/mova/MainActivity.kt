package com.mabdullah412.mova

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.mabdullah412.mova.onboarding.activities.OnboardingActivity
import com.mabdullah412.mova.splash.activities.SplashActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this, OnboardingActivity::class.java))
    }
}
