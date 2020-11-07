package com.example.fallhack2020

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import com.example.fallhack2020.model.SignUpForm
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text
import kotlin.math.sign

class SignUpActivity : AppCompatActivity() {

    private var signUpForm = SignUpForm()
    private lateinit var password: EditText
    private lateinit var emailAddress: EditText
    private lateinit var firstName:EditText
    private lateinit var lastName:EditText
    private lateinit var phoneNum:EditText
    private lateinit var errorText: TextView
    private lateinit var dobText: TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setupEditTexts()
        auth = Firebase.auth
        findViewById<Button>(R.id.signupButton).setOnClickListener {
            signUp()
        }

    }

    private fun signUp() {
        Log.d("bugg","signing up")
        verifyInputs()
    }

    private fun verifyInputs() {
        signUpForm.firstName = firstName.text.toString()
        signUpForm.lastName = lastName.text.toString()
        signUpForm.phoneNumber = phoneNum.text.toString()
        signUpForm.email = emailAddress.text.toString()
        signUpForm.password = password.text.toString()

        if (signUpForm.isEverythingFilled()) {
            errorText.visibility = View.GONE
            setupFirebaseAuth()
        } else {
            errorText.text = "Something is missing...."
            errorText.visibility = View.VISIBLE
        }
    }

    private fun setupFirebaseAuth() {
        Log.d("bugg","asking to create auth")
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(signUpForm.email,signUpForm.password).addOnCompleteListener(this) {task ->
            Log.d("bugg","create user task is progressed"+ task)

            if (task.isSuccessful) {
                Log.d("bugg","create user task is successfull")
                val user = auth.currentUser
                user?.sendEmailVerification()
                val database = Firebase.database
                val myRef = database.getReference("users/")
                signUpForm.password=""
                myRef.child(user!!.uid).setValue(signUpForm).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Log.d("bugg","db user task is successfull")
                        startActivity(Intent(this, MainActivity::class.java))
                    } else {
                        Log.d("bugg","db user task is fked")

                    }
                }
            } else {
                Log.d("bugg","create user task is fked up")
                Log.d("bugg"," "+ task.exception?.localizedMessage)
                errorText.visibility = View.VISIBLE
                errorText.text = "Email address already exists"
            }
        }
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