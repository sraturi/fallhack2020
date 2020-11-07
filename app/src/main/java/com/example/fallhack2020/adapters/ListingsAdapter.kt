package com.example.fallhack2020.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fallhack2020.ItemDetailsActivity
import com.example.fallhack2020.R

class ListingsAdapter : RecyclerView.Adapter<ListingsAdapter.ViewHolder>() {
    private val descriptions = arrayOf("d116df5",
        "36ffc75", "f5cfe78", "5b87628",
        "db8d14e", "9913dc4", "e120f96",
        "466251b")

    private val names = arrayOf("Guitar", "Teknologi",
        "Keluarga", "Bisnis",
        "Keluarga", "Hutang",
        "Teknologi", "Pidana")

    private val prices = arrayOf(17.99,
        10.00, 15.99, 123.45,
        9999.99, 1.50, 0.01,
        200.00)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_listing, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ListingsAdapter.ViewHolder, position: Int) {
        holder.itemName.text = names[position]
        holder.itemDescription.text = descriptions[position]
        holder.itemPrice.text = prices[position].toString()
    }

    override fun getItemCount(): Int {
        return descriptions.size
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