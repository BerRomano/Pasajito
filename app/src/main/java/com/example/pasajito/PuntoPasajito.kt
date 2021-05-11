package com.example.pasajito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent

class PuntoPasajito : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_punto_pasajito)
        val validCodigosPuntoPasajito = listOf(
            CodigosPuntoPasajito("AD53-B2T5", 5.0),
            CodigosPuntoPasajito("M8Y37-47B2", 10.0),
            CodigosPuntoPasajito("P6P8-QR7B", 2.0)
        )}
    }
