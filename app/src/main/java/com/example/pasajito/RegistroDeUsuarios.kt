package com.example.pasajito

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registro_de_usuarios.*


class RegistroDeUsuarios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPreferencesManager = SharedPreferencesManager()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_de_usuarios)

        creado.setOnClickListener {
            if (editTextTextPassword3.text.toString() == editTextTextPassword4.text.toString()) {
                val intent = Intent(this, MenuPrincipal::class.java)
                val usuarioAGuardar = Usuario(editTextTextPersonName2.text.toString(), editTextTextPassword3.text.toString(),
                        editTextTextEmailAddress2.text.toString(), 20.0)
                sharedPreferencesManager.crearUsuario(this, usuarioAGuardar)
                startActivity(intent)
            }else{
                Toast.makeText(baseContext, "Las contraseñas no son iguales", Toast.LENGTH_SHORT).show()
            }
        }
    }
}