package com.example.pasajito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_inicio_de_sesion.*
import kotlinx.android.synthetic.main.activity_metodo_de_pago.*

class MetodoDePago : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metodo_de_pago)


        puntoPasajito.setOnClickListener {
            val intent = Intent(this, PuntoPasajito::class.java)
            startActivity(intent)
        }

            VincularTarjeta.setOnClickListener {
                val intent = Intent(this, VincularCuenta::class.java)
                startActivity(intent)
            }
    }
}