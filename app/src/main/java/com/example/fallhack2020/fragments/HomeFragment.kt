package com.example.fallhack2020.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fallhack2020.AddItemActivity
import com.example.fallhack2020.R
import com.example.fallhack2020.adapters.ListingsAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.listings).apply {
            // set a LinearLayoutManager to handle Android RecyclerView Behaviour
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = ListingsAdapter()
        }

        view.findViewById<Button>(R.id.add_rental).setOnClickListener {
            val intent = AddItemActivity.createIntent(context)
            context?.startActivity(intent)
        }
    }
}