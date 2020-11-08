package com.example.fallhack2020.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.fallhack2020.AddItemActivity
import com.example.fallhack2020.R
import com.example.fallhack2020.SearchActivity


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

        view.findViewById<Button>(R.id.add_rental).setOnClickListener {
            val intent = AddItemActivity.createIntent(context)
            context?.startActivity(intent)
        }

        view.findViewById<SearchView>(R.id.searchBar).setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query == null) {
                    Toast.makeText(context, "Invalid search", Toast.LENGTH_LONG).show()
                    return false
                }
                Log.d("bugg","launching search activity")
                val intent = Intent(context,SearchActivity::class.java)
                intent.putExtra("query",query)
                startActivity(intent)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }
}