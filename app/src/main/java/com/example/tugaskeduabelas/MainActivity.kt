package com.example.tugaskeduabelas

import MakananAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var makananList: ArrayList<Makanan>
    lateinit var imageID: Array<Int>
    lateinit var name: Array<String>
    lateinit var price: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageID = arrayOf(
            R.drawable.img_rendang,
            R.drawable.img_gudeg,
            R.drawable.img_bakso,
            R.drawable.img_gado,
            R.drawable.img_rawon,
            R.drawable.img_pempek,
            R.drawable.img_keraktelor,
            R.drawable.img_ketoprak,
            R.drawable.img_sate,
            R.drawable.img_nasiliwet,
        )

        name = arrayOf(
            "Rendang", "Gudeg", "Bakso", "Gado - Gado", "Rawon", "Pempek", "Kerak Telor", "Ketoprak", "Sate", "Nasi Liwet"
        )
        price = arrayOf(
            "Rp. 20.000", "Rp. 15.000", "Rp. 10.000", "Rp. 15.000", "Rp. 15.000", "Rp. 15.000", "Rp. 25.0000", "Rp. 15.0000", "Rp. 25.0000", "Rp. 30.0000"
        )
        recyclerView = findViewById(R.id.rv_makanan)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        makananList = arrayListOf<Makanan>()
        getMakanan()
    }

    private fun getMakanan() {
        for (i in imageID.indices) {
            val makanan = Makanan(imageID[i], name[i], price[i])
            makananList.add(makanan)
        }
        recyclerView.adapter = MakananAdapter(makananList)
    }
}