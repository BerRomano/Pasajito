package com.example.pasajito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_punto_pasajito.*

class PuntoPasajito : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_punto_pasajito)
        val validCodigosPuntoPasajito = listOf(
            CodigosPuntoPasajito("AD53-B2T5", 5.0),
            CodigosPuntoPasajito("M8Y37-47B2", 10.0),
            CodigosPuntoPasajito("P6P8-QR7B", 2.0)
        )}

    val codigo = editTextTextMultiLine.text.toString()
            for ( user in validUsersList) {
                if (user.codigo == codigo) {

                }
                else {
                    Toast.makeText(this, "Login Incorrecto!", Toast.LENGTH_LONG).show()
                }
            }
 }

