package com.example.fallhack2020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.fallhack2020.model.SignUpForm

class SignUpActivity : AppCompatActivity() {

    private var signUpForm = SignUpForm()
    private lateinit var password: EditText
    private lateinit var emailAddress: EditText
    private lateinit var firstName:EditText
    private lateinit var lastName:EditText
    private lateinit var phoneNum:EditText
    private lateinit var errorText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setupEditTexts()
        findViewById<Button>(R.id.signupButton).setOnClickListener {
            signUp()
        }

    }

    private fun signUp() {
        TODO("Not yet implemented")
    }

    private fun setupEditTexts() {
        password = findViewById(R.id.editTextTextPassword)
        emailAddress = findViewById(R.id.ddEmailEditText)
        firstName = findViewById(R.id.firstNameText)
        lastName = findViewById(R.id.lastNameText)
        phoneNum = findViewById(R.id.phoneNumEditText)
        errorText= findViewById(R.id.errorText)

    }
}