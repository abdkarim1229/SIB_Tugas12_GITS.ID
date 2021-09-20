package com.example.tugaskeduabelas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val imageMakanan: ImageView = findViewById(R.id.details_image)
        val namaMakanan: TextView = findViewById(R.id.details_nama)
        val hargaMakanan: TextView = findViewById(R.id.details_harga)
        val detailsMakanan: TextView = findViewById(R.id.details_detail)
        val bundle: Bundle? = intent.extras
        val nama = bundle!!.getString("name")
        val image = bundle.getInt("imageID")
        val harga = bundle.getString("price")
        val details = bundle.getString("detail")

        imageMakanan.setImageResource(image)
        namaMakanan.text = nama
        hargaMakanan.text = harga
        detailsMakanan.text = details

    }
}