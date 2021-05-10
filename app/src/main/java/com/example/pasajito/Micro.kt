package com.example.pasajito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_micro.*

class Micro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_micro)

        pagoMicro.setOnClickListener {
            val intent = Intent(this, Pagar::class.java)
            startActivity(intent)
        }

        rutasMicro.setOnClickListener {
            val intent = Intent(this, Rutas::class.java)
            startActivity(intent)
        }
    }
}