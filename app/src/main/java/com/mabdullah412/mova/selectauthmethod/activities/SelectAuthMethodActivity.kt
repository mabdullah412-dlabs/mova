package com.mabdullah412.mova.selectauthmethod.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.google.android.material.button.MaterialButton
import com.mabdullah412.mova.R
import com.mabdullah412.mova.signin.activities.SignInActivity

class SelectAuthMethodActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_auth_method)

        val btnBack: MaterialButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        val btnSignInWithPassword: Button = findViewById(R.id.btnSignInWithPassword)
        btnSignInWithPassword.setOnClickListener {
            Intent(this, SignInActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}
