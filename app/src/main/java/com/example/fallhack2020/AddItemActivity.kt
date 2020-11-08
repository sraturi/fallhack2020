package com.example.fallhack2020

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AddItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)
    }

    companion object {
        fun createIntent(context: Context?): Intent {
            return Intent(context, this::class.java)
        }
    }
}