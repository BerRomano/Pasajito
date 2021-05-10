package com.example.pasajito
import java.io.Serializable

data class Usuario(val username: String, val password: String, val correo: String, val saldo: Double): Serializable