package com.example.fallhack2020

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class SignInActivity : AppCompatActivity() {

    private lateinit var email:EditText
    private lateinit var password:EditText
    private lateinit var signupText:TextView
    private lateinit var signInButton:Button
    private lateinit var errorText:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        supportActionBar?.hide()
        setupFields()

        signInButton.setOnClickListener(View.OnClickListener {
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Signing In...")
            progressDialog.show()
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email.text.toString(),password.text.toString()).addOnCompleteListener(this) {
                if (it.isSuccessful){
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                } else {
                    errorText.visibility = View.VISIBLE
                }
                progressDialog.cancel()
            }
        })

        signupText.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        })
    }

    private fun setupFields() {
        email = findViewById(R.id.emailEditText)
        password = findViewById(R.id.editTextTextPassword2)
        signInButton = findViewById(R.id.signupButton)
        signupText = findViewById(R.id.signUpText)
        errorText = findViewById(R.id.errorText1)
    }
}