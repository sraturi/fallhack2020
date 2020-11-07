package com.example.fallhack2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fallhack2020.model.SignUpForm

class SignUpActivity : AppCompatActivity() {

    private var signUpForm = SignUpForm()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
    }
}