package com.mabdullah412.mova.onboarding.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.mabdullah412.mova.R
import com.mabdullah412.mova.selectauthmethod.activities.SelectAuthMethodActivity

class OnboardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val btnGetStarted: Button = findViewById(R.id.btnGetStarted)
        btnGetStarted.setOnClickListener {
            Intent(this, SelectAuthMethodActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}
