package com.example.pasajito
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.widget.Toast
import com.google.gson.Gson
import java.lang.Double.compare

class SharedPreferencesManager {
        fun crearUsuario (context: Context, usuario: Usuario){
            val usuarioJson = Gson().toJson(usuario)
            val prefs = context.getSharedPreferences("datos", MODE_PRIVATE)
            val prefsEditor = prefs.edit()
            prefsEditor.putString("usuario", usuarioJson)
            prefsEditor.apply()
        }

    fun obtenerUsuario(context: Context): Usuario? {
        val prefs = context.getSharedPreferences("datos", MODE_PRIVATE)
        val usuarioJson = prefs.getString("usuario", null)
        if(usuarioJson != null) {
            val usuario = Gson().fromJson(usuarioJson, Usuario::class.java)
            return usuario
        } else {
            return null
        }
    }
    fun restarSaldo(context: Context, cantidad : Double) {
        val usuario = obtenerUsuario(context)
        val nuevoSaldo = usuario?.saldo?.minus(cantidad)
        //val n= nuevoSaldo?.let { compare(it, 0.0) }
        //if (n != null) {
          //  if (n<0.0){
            //    Toast.makeText(baseContext, "Saldo insuficiente", Toast.LENGTH_SHORT).show()
            //}
        //}
        usuario?.saldo= nuevoSaldo ?: 0.0
        crearUsuario(context, usuario!!)
    }
    fun sumarSaldo(context: Context, cantidad : Double) {
        val usuario = obtenerUsuario(context)
        val nuevoSaldo = usuario?.saldo?.plus(cantidad)
        usuario?.saldo = nuevoSaldo ?: 0.0
        crearUsuario(context, usuario!!)
    }
    fun obtenerSaldo(context: Context): Double? {
        val usuario = obtenerUsuario(context)
        val saldo = usuario?.saldo
        return saldo
    }
}