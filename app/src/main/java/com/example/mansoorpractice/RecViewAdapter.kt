package com.example.mansoorpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecViewAdapter(val data: List<ModalClasss>) :
    RecyclerView.Adapter<RecViewAdapter.ViewHolder>() {
    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name=itemView.findViewById<TextView>(R.id.name)
        val address=itemView.findViewById<TextView>(R.id.address)
        fun bind(data:ModalClasss)
        {
            name.text=data.name
            address.text=data.address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.revview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}