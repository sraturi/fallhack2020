package com.example.fallhack2020

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.example.fallhack2020.data.Item

class ItemDetailDialog(context: Context, val item:Item) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.details_dialog)

        findViewById<TextView>(R.id.itemName).text = item.name
        findViewById<TextView>(R.id.itemDesc).text = item.description
        findViewById<TextView>(R.id.priceT).text = "$${item.price}/month"

        findViewById<Button>(R.id.rentB).setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "Coming Soon!!",Toast.LENGTH_LONG).show()
        })
        findViewById<ImageButton>(R.id.backbutton).setOnClickListener(View.OnClickListener {
            cancel()
        })
    }
}