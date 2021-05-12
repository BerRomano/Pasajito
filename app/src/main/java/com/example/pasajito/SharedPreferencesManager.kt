package com.example.pasajito
import android.content.Context
import android.content.Context.MODE_PRIVATE
import com.google.gson.Gson


class SharedPreferencesManager {
    fun crearUsuario(context: Context, usuario: Usuario) {
        val usuarioExistente =
                obtenerUsuarios(context).find { usuariosRegistrados -> usuariosRegistrados.username == usuario.username }

        if(usuarioExistente == null) {
            val usuariosRegistrados = obtenerUsuarios(context).toMutableList()
            usuariosRegistrados.add(usuario)

            val usuariosRegistradosJson = Gson().toJson(usuariosRegistrados)
            val usuarioJson = Gson().toJson(usuario)

            val prefs = context.getSharedPreferences("datos", MODE_PRIVATE)
            val prefsEditor = prefs.edit()
            prefsEditor.putString("usuarios", usuariosRegistradosJson)
            prefsEditor.putString("usuarioIniciado", usuarioJson)
            prefsEditor.apply()
        }
    }
    fun guardarUsuarioIniciado (context: Context, usuario: Usuario){

        val prefs = context.getSharedPreferences("datos", MODE_PRIVATE)
        val prefsEditor = prefs.edit()

        prefsEditor.apply()
    }
    fun obtenerUsuario(context: Context): Usuario?{
        val prefs = context.getSharedPreferences("datos", MODE_PRIVATE)
        val usuarioJson = prefs.getString("usuarioIniciado", null)
        if(usuarioJson != null) {
            val usuario = Gson().fromJson(usuarioJson, Usuario::class.java)
            return usuario
        } else {
            return null
        }
    }

    fun obtenerUsuarios(context: Context): List<Usuario> {
        val prefs = context.getSharedPreferences("datos", MODE_PRIVATE)
        val usuarioJson = prefs.getString("usuario", null)
        if(usuarioJson != null) {
            val usuarios: List<Usuario> = Gson().fromJson(usuarioJson)
            return usuarios
        } else {
            return listOf()
        }
    }
    fun restarSaldo(context: Context, cantidad : Double) {
        val usuario = obtenerUsuario(context)
        val nuevoSaldo = usuario?.saldo?.minus(cantidad)
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