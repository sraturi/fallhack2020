package com.example.fallhack2020

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fallhack2020.data.Item
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class AddItemActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)

        findViewById<Button>(R.id.cancel).setOnClickListener {
            finish()
        }
        findViewById<Button>(R.id.postRental).setOnClickListener {
            // firebase create item
            database = Firebase.database.reference
            val item: Item = getItem()
            val r = Random()
            val itemId = r.nextInt(10000000).toString()
            database.child("items").child(itemId).setValue(item)
            Toast.makeText(applicationContext, "Posting created", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    private fun getItem(): Item {
        val name = findViewById<EditText>(R.id.name).text.toString()
        val description = findViewById<EditText>(R.id.description).text.toString()
        val streetAddress = findViewById<EditText>(R.id.street_address).text.toString()
        val city = findViewById<EditText>(R.id.city).text.toString()
        val postalCode = findViewById<EditText>(R.id.postal_code).text.toString()
        val phone = findViewById<EditText>(R.id.phone).text.toString()
        val price = findViewById<EditText>(R.id.price).text.toString().toDouble()
        val category = findViewById<TextView>(R.id.category).text.toString()
        return Item(name, description, price, streetAddress, city, postalCode, category, phone)
    }


    companion object {
        fun createIntent(context: Context?): Intent {
            return Intent(context, AddItemActivity::class.java)
        }
    }
}