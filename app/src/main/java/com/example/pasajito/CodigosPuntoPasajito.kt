package com.example.pasajito
import com.google.gson.annotations.Expose
import java.io.Serializable

    data class CodigosPuntoPasajito(
        @Expose val codigo: String,
        @Expose val monto: Double
    ): Serializable
