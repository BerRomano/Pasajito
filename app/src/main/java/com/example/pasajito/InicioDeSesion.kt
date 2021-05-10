package com.example.pasajito
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_inicio_de_sesion.*
import kotlinx.android.synthetic.main.activity_new_password.*


class InicioDeSesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_de_sesion)
        val validUsersList = listOf(
            Usuario("Berro", "20305060"),
            Usuario("Daniel", "Pelota"),
            Usuario("Aimee", "291915"),
            Usuario("Emanuel", "Lore123")
        )
       inicioSesion.setOnClickListener {
            val username = editTextTextEmailAddress1.text.toString()
            val password = editTextTextPassword1.text.toString()
             for (user in validUsersList) {
                if (user.username == username && user.password == password) {
                    val intent = Intent(this, MenuPrincipal::class.java)
                    intent.putExtra("username", username)
                    intent.putExtra("password", password)
                    intent.putExtra("user", user)
                    startActivity(intent)
                    break
                } else {
                    Toast.makeText(this, "Login Incorrecto!", Toast.LENGTH_LONG).show()
                }
            }

        }

        registrate.setOnClickListener {
            val intent = Intent(this, RegistroDeUsuarios::class.java)
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

