package com.example.pasajito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_minibus.*

class Minibus : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_minibus)

        botonrutas.setOnClickListener {
            val intent = Intent(this, Rutas::class.java)
            startActivity(intent)
        }

        pagarMini.setOnClickListener {
            val intent = Intent(this, Pagar::class.java)
            startActivity(intent)
        }
    }

}