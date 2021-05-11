package com.example.pasajito
import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class SharedPreferencesManager {
    fun crearUsuario(context: Context, usuario: Usuario) {
        val usuarioExistente =
                obtenerUsuarios(context).find { usuariosRegistrados -> usuariosRegistrados.username == usuario.username }

        if(usuarioExistente == null) {
            val usuariosRegistrados = obtenerUsuarios(context).toMutableList()
            usuariosRegistrados.add(usuario)

            val usuariosRegistradosJson = gson.toJson(usuariosRegistrados)

            val prefs = context.getSharedPreferences("datos", MODE_PRIVATE)
            val prefsEditor = prefs.edit()
            prefsEditor.putString("usuarios", usuariosRegistradosJson)
            prefsEditor.apply()
        }
    }

    fun obtenerUsuarios(context: Context): List<Usuario> {
        val prefs = context.getSharedPreferences("datos", MODE_PRIVATE)
        val usuarioJson = prefs.getString("usuario", null)
        if(usuarioJson != null) {
            val usuarios: List<Usuario> = gson.fromJson(usuarioJson)
            return usuarios
        } else {
            return listOf()
        }
    }
    fun restarSaldo(context: Context, cantidad : Double) {
        val usuario = obtenerUsuarios(context)
        val nuevoSaldo = usuario?.saldo?.minus(cantidad)
        usuario?.saldo= nuevoSaldo ?: 0.0
        crearUsuario(context, usuario!!)
    }
    fun sumarSaldo(context: Context, cantidad : Double) {
        val usuario = obtenerUsuarios(context)
        val nuevoSaldo = usuario?.saldo?.plus(cantidad)
        usuario?.saldo = nuevoSaldo ?: 0.0
        crearUsuario(context, usuario!!)
    }
    fun obtenerSaldo(context: Context): Double? {
        val usuario = obtenerUsuarios(context)
        val saldo = usuario?.saldo
        return saldo
    }
}