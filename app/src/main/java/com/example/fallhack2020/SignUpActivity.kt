package com.example.fallhack2020

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.fallhack2020.model.SignUpForm
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    private var signUpForm = SignUpForm()
    private lateinit var password: EditText
    private lateinit var confirmPassword: EditText
    private lateinit var emailAddress: EditText
    private lateinit var errorText: TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        //checkIfWeAreLoggedIn()
        setupEditTexts()
        supportActionBar?.hide()
        auth = Firebase.auth
        findViewById<Button>(R.id.signupButton).setOnClickListener {
            signUp()
        }

    }

    private fun checkIfWeAreLoggedIn() {
        val user = Firebase.auth.currentUser
        if (user != null) {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }

    private fun signUp() {
        Log.d("bugg","signing up")
        verifyInputs()
    }

    private fun verifyInputs() {
        signUpForm.email = emailAddress.text.toString()
        signUpForm.password = password.text.toString()
        signUpForm.confirmPassword = confirmPassword.text.toString()
        if (signUpForm.isEverythingFilled()) {
            errorText.visibility = View.GONE
            setupFirebaseAuth()
        } else {
            errorText.text = "Something is missing...."
            errorText.visibility = View.VISIBLE
        }
    }

    private fun setupFirebaseAuth() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Signing up")
        progressDialog.show()
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(signUpForm.email,signUpForm.password).addOnCompleteListener(this) {task ->

            if (task.isSuccessful) {
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
                Log.d("bugg"," "+ task.exception?.localizedMessage)
                errorText.visibility = View.VISIBLE
                errorText.text = "Email address already exists"
            }
            progressDialog.cancel()
        }
    }

    private fun setupEditTexts() {
        password = findViewById(R.id.editTextTextPassword)
        emailAddress = findViewById(R.id.emailEditText)
        confirmPassword = findViewById(R.id.editTextTextPassword2)
        errorText = findViewById(R.id.errorText)

    }
}