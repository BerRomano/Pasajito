package com.example.pasajito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_minibus.*

class minibus : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minibus)

        botonrutas.setOnClickListener {
            val intent = Intent(this, rutas::class.java)
            startActivity(intent)
        }
    }

}