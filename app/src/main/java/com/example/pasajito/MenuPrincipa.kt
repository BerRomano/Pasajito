package com.example.pasajito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu_principa.*

class MenuPrincipa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principa)

        minibusBoton.setOnClickListener {
            val intent = Intent(this, minibus::class.java)
            startActivity(intent)
        }

        microBoton.setOnClickListener {
            val intent = Intent(this, Micro::class.java)
            startActivity(intent)
        }

        trufiBoton.setOnClickListener {
            val intent = Intent(this, trufi::class.java)
            startActivity(intent)
        }

        taxiBoton.setOnClickListener {
            val intent = Intent(this, MetodoDePago::class.java)
            startActivity(intent)
        }

    }

}