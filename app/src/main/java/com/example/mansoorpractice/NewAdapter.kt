package com.example.mansoorpractice

import android.media.Image
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewAdapter(val image: List<Uri>, val myInterface: MyInterface) :
    RecyclerView.Adapter<MyViewHolderTemp>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderTemp {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.revview_item, parent, false)
        return MyViewHolderTemp(view)
    }

    override fun onBindViewHolder(holder: MyViewHolderTemp, position: Int) {
        // holder.myviews(data[position],myInterface)
        holder.image.setImageURI(image[position])
    }

    override fun getItemCount() = image.size
}

class MyViewHolderTemp(itemView: View) : RecViewAdapter.ViewHolder(itemView) {
    val nm = itemView.findViewById<TextView>(R.id.name)
    val adrs = itemView.findViewById<TextView>(R.id.address)
    val image = itemView.findViewById<ImageView>(R.id.multiimage)

    fun myviews(data: ModalClasss, myInterface: MyInterface) {
        nm.text = data.name
        adrs.text = data.address
        itemView.setOnClickListener {
            myInterface.myclicked(adapterPosition)
        }
    }
}
