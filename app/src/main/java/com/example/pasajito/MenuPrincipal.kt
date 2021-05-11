package com.example.pasajito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu_principa.*

class MenuPrincipal : AppCompatActivity() {
    val sharedPreferencesManager = SharedPreferencesManager()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principa)
        textView2.text = sharedPreferencesManager.obtenerSaldo(this).toString()

        minibusBoton.setOnClickListener {
            val intent = Intent(this, Minibus::class.java)
            startActivity(intent)
        }

        microBoton.setOnClickListener {
            val intent = Intent(this, Micro::class.java)
            startActivity(intent)
        }

        trufiBoton.setOnClickListener {
            val intent = Intent(this, Trufi::class.java)
            startActivity(intent)
        }

        taxiBoton.setOnClickListener {
            val intent = Intent(this, Taxi::class.java)
            startActivity(intent)
        }
        recargarpp.setOnClickListener {
            val intent = Intent(this, MetodoDePago::class.java)
            startActivity(intent)

        }
    }
    override fun onRestart() {
        super.onRestart()
        textView2.text = sharedPreferencesManager.obtenerSaldo(this).toString()
    }
}