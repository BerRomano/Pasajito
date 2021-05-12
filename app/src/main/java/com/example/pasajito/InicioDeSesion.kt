package com.example.pasajito
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_inicio_de_sesion.*
import kotlinx.android.synthetic.main.activity_new_password.*


class InicioDeSesion : AppCompatActivity() {
    val sharedPreferencesManager = SharedPreferencesManager()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_de_sesion)
       inicioSesion.setOnClickListener {
           val username = editTextTextEmailAddress1.text.toString()
           val password = editTextTextPassword1.text.toString()
           val correo = editTextTextEmailAddress1.text.toString()
           val validUsers = sharedPreferencesManager.obtenerUsuarios(this)
           for (validUser in validUsers) {
                   if ((validUser.username == username || validUser.correo == correo) && validUser.password == password) {
                       val intent = Intent(this, MenuPrincipal::class.java)
                       sharedPreferencesManager.guardarUsuarioIniciado(this,validUser)
                       startActivity(intent)
               }
           }
        }
        registrate.setOnClickListener {
            val intent = Intent(this, RegistroDeUsuarios::class.java)
            startActivity(intent)
        }
        contraseña.setOnClickListener {
            val intent = Intent(this, NewPassword::class.java)
            startActivity(intent)
        }


        //override fun onStart() {
        //  super.onStart()
        //println("onStart InicioDeSesion2")
        //}

        //override fun onResume() {
        //  super.onResume()
        //println("onResume InicioDeSesion2")
        //}

        //override fun onPause() {
        //  super.onPause()
        //println("onPause InicioDeSesion2")
        //}

        //override fun onStop() {
        //  super.onStop()
        //println("onStop InicioDeSesion2")
        //}

        // override fun onDestroy() {
        //   super.onDestroy()
        // println("onDestroy InicioDeSesion2")
        //}

        //override fun onRestart() {
        //println("onRestart InicioDeSesion2")
        //}
    }
}

