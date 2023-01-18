package com.example.mansoorpractice

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() ,MyInterface{


    lateinit var recVIew:RecyclerView
    lateinit var multiimage: List<Uri>
    lateinit var inter:MyInterface



    private val openGalleryForMultipleImageSelection=registerForActivityResult(
        ActivityResultContracts.GetMultipleContents()){
        multiimage=it
        recVIew= findViewById(R.id.rec_view)
        inter=this
        recVIew.layoutManager=LinearLayoutManager(this)
        val adapter = NewAdapter(multiimage,inter)
        recVIew.adapter=adapter
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //recVIew= findViewById(R.id.rec_view)
        val click:Button=findViewById(R.id.click)

        click.setOnClickListener{
            openGalleryForMultipleImageSelection.launch("image/*")
        }

        //recVIew.layoutManager=LinearLayoutManager(this)
        //ad=NewAdapter(populate(),this)
//        adapter= NewAdapter()
//        recVIew.adapter=ad
    }






    fun MultiImagePiclk(){
        lateinit var multiimage: List<Uri>
        lateinit var adapter:NewAdapter
        var recVIew:RecyclerView = findViewById(R.id.rec_view)

    }

    fun populate():List<ModalClasss>{
        val data= mutableListOf<ModalClasss>()

        for (i in 0..10){
            val _data=ModalClasss("name $i","address $i")
            data.add(_data)
        }
        return data
    }

    override fun myclicked(postion: Int) {
        Toast.makeText(this,"You Clicked $postion",Toast.LENGTH_SHORT).show()
    }

}