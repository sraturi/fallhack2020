package com.example.fallhack2020

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fallhack2020.adapters.ListingsAdapter
import com.example.fallhack2020.data.Item
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_search)
        Log.d("bugg","search activty")
//       val query:String = intent.getStringExtra("query").toString()
//        val database = Firebase.database.reference.child("rentals")
//
//        val q = database.orderByChild("name")
//        q.addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                val list = ArrayList<Item>()
//                for (singleSnapshot in dataSnapshot.children) {
//
//                    val item = singleSnapshot.getValue(Item::class.java)
//                    item?.let {
//                        if (query.contains(it.name.toString())) {
//                            list.add(it)
//                        }
//                    }
//                }
//                val adapter1 = ListingsAdapter(list)
//                findViewById<RecyclerView>(R.id.listRecycler).apply {
//                    adapter = adapter1
//                    layoutManager = LinearLayoutManager(this@SearchActivity)
//                }
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {
//                Log.e("bugg", "onCancelled", databaseError.toException())
//            }
//        })

        val list = ArrayList<Item>()
        for (i in 0..11) {
            list.add(Item("Name $i"," this is the description $i", i.toDouble()))
        }
        Log.d("bugg","I have list: ${list.size}")

        findViewById<RecyclerView>(R.id.listRecycler).apply {
            Log.d("bugg","applying adapter")
            adapter = ListingsAdapter(list)
            layoutManager = LinearLayoutManager(this@SearchActivity)
        }

    }
}