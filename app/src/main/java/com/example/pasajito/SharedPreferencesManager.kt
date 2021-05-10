package com.example.pasajito
import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.google.gson.Gson

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
}