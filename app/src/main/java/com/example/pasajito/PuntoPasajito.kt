package com.example.pasajito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_punto_pasajito.*

class PuntoPasajito : AppCompatActivity() {
    val sharedPreferencesManager = SharedPreferencesManager()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_punto_pasajito)
        val validCodigosPuntoPasajito = listOf(
            CodigosPuntoPasajito("AD53-B2T5", 2.0),
            CodigosPuntoPasajito("M8Y37-47B2", 5.0),
            CodigosPuntoPasajito("P6P8-QR7B", 10.0)
        )
        recargarpp.setOnClickListener {
            val codigo = editTextTextMultiLine.text.toString()
            for ( CodigosPuntoPasajito in validCodigosPuntoPasajito) {
                if (CodigosPuntoPasajito.codigo != codigo){
                    Toast.makeText(baseContext, "Código incorrecto", Toast.LENGTH_SHORT).show()
                }else{
                    sharedPreferencesManager.sumarSaldo(this, CodigosPuntoPasajito.monto)
                    Toast.makeText(baseContext, "Código correcto saldo + "+ CodigosPuntoPasajito.monto, Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }

 }

