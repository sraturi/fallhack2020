package com.example.fallhack2020

import android.app.ProgressDialog
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.TextView
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
       val query:String = intent.getStringExtra("query").toString()

        findViewById<TextView>(R.id.queryText).setText("Showing results for: $query")
        val database = Firebase.database.reference.child("items")

        val q = database.orderByChild("name")
        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Fetching list of items...")
        progressDialog.show()
        q.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val list = ArrayList<Item>()
                Log.d("bugg","got the results: ${dataSnapshot.children.count()}")
                if (dataSnapshot.children.count() == 0){
                    findViewById<TextView>(R.id.queryText).setText("There are no results for: $query   :(\n\n Trying searching for something else.....")
                    return
                }
                for (singleSnapshot in dataSnapshot.children) {
                    Log.d("bugg","single item: ${singleSnapshot.toString()}")
                    val item = singleSnapshot.getValue(Item::class.java)
                    Log.d("bugg","item: ${item.toString()}")
                    item?.let {
                        //if (query.contains(it.name.toString())) {
                            list.add(it)
                        Log.d("bugg","item2: ${it.toString()}")
                        //}
                    }
                }

                val adapter1 = ListingsAdapter(list)
                findViewById<RecyclerView>(R.id.listRecycler).apply {
                    adapter = adapter1
                    layoutManager = LinearLayoutManager(this@SearchActivity)
                }
                progressDialog.cancel()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.e("bugg", "onCancelled", databaseError.toException())
            }
        })

    }
}