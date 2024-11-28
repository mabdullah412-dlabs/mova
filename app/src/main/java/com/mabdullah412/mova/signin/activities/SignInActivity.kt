package com.mabdullah412.mova.signin.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import com.google.android.material.button.MaterialButton
import com.mabdullah412.mova.R

class SignInActivity : ComponentActivity() {

    private var etEmail: EditText? = null
    private var etPassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // get text fields reference
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)

        // remove screen when back button is pressed
        val backBtn: MaterialButton = findViewById(R.id.btnBack)
        backBtn.setOnClickListener {
            finish()
        }

        // signup btn onclick listener
        val btnSignUp: Button = findViewById(R.id.btnSignUp)
        btnSignUp.setOnClickListener {

            val bEmailIsValid: Boolean = validateEmail()
            val bPasswordIsValid: Boolean = validatePassword()

            if (bEmailIsValid && bPasswordIsValid) {
                TODO("Login user")
            }
        }

        // email field on text change
        etEmail?.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                validateEmail()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // password field on text change
        etPassword?.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                validatePassword()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    /**
     * Returns `true` if password field is not empty,
     * also updates the corresponding [EditText]'s background and border to reflect default and
     * error states
     */
    private fun validatePassword() : Boolean {
        etPassword?.text.let {
            if (it.isNullOrEmpty()) {
                etPassword?.apply {
                    setBackgroundResource(R.drawable.input_field_error_shape)
                }
                return false
            } else {
                etPassword?.apply {
                    setBackgroundResource(R.drawable.input_field_shape)
                }
                return true
            }
        }
    }

    /**
     * Returns `true` if email is valid,
     * also updates the corresponding [EditText]'s background and border to reflect default and
     * error states
     */
    private fun validateEmail() : Boolean {
        etEmail?.text.let {
            // check if email is valid
            if (!isValidEmail(it.toString())) {
                etEmail?.apply {
                    setBackgroundResource(R.drawable.input_field_error_shape)
                }
                return false
            } else {
                etEmail?.apply {
                    setBackgroundResource(R.drawable.input_field_shape)
                }
                return true
            }
        }
    }

    /**
     * Validates email pattern
     */
    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
