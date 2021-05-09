package com.example.pasajito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_trufi.*

class Trufi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trufi)
        pagar.setOnClickListener {
            val intent = Intent(this, Pagar::class.java)
            startActivity(intent)
        }
        verRutas.setOnClickListener {
            val intent = Intent(this, verRutas::class.java)
            startActivity(intent)
        }
    }
}