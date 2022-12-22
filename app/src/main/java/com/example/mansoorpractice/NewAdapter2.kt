package com.example.mansoorpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewAdapter2(private val data: List<ModalClasss>,val onClick:(position: Int)->Unit): RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.revview_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindview(data[position],onClick)
    }

    override fun getItemCount()=data.size
}
class MyViewHolder(itemView: View) : RecViewAdapter.ViewHolder(itemView) {
    val nm=itemView.findViewById<TextView>(R.id.name)
    val adrs=itemView.findViewById<TextView>(R.id.address)

    fun bindview(data: ModalClasss, onClick: (position: Int) -> Unit){
        nm.text=data.name
        adrs.text=data.address
        itemView.setOnClickListener {
            onClick(adapterPosition)
        }
    }

    fun myviews(modalClasss: ModalClasss, myInterface: MyInterface) {

    }
}
