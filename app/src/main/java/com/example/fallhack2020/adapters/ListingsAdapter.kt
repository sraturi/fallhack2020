package com.example.fallhack2020.adapters

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fallhack2020.ItemDetailsActivity
import com.example.fallhack2020.R
import com.example.fallhack2020.data.Item

class ListingsAdapter(private val list:List<Item>) : RecyclerView.Adapter<ListingsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_listing, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ListingsAdapter.ViewHolder, position: Int) {
        holder.itemName.text = list[position].name
        holder.itemDescription.text = list[position].description
        holder.itemPrice.text = "$${list[position].price}/month"
        Log.d("bugg"," I am here")
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemName: TextView = itemView.findViewById(R.id.item_name)
        var itemDescription: TextView = itemView.findViewById(R.id.item_description)
        var itemPrice: TextView = itemView.findViewById(R.id.item_price)

        init {
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                val context = itemView.context
                val intent = Intent(context, ItemDetailsActivity::class.java).apply {
                    putExtra("NUMBER", position)
                    putExtra("CODE", itemName.text)
                    putExtra("CATEGORY", itemDescription.text)
                    putExtra("CONTENT", itemPrice.text)
                }
                context.startActivity(intent)
            }
        }
    }
}