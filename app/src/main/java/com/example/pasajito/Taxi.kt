package com.example.pasajito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_taxi.*

class Taxi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taxi)

        pagarTaxi.setOnClickListener {
            val intent = Intent(this, Pagar::class.java)
            startActivity(intent)
        }
        lineasTaxi.setOnClickListener {
            val intent = Intent(this, ListaTaxis::class.java)
            startActivity(intent)
        }
    }


}