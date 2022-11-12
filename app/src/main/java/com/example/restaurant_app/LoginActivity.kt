package com.example.restaurant_app

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class LoginActivity : AppCompatActivity() {
    private var userInicio: EditText? = null
    private var passwordInicio: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userInicio = findViewById(R.id.edit_inicio_user)
        passwordInicio = findViewById(R.id.edit_inicio_password)

    }

    //funcion para inicio de sesion
    fun loginAcentral(xx: View)
    {
        var username: String = userInicio!!.text.toString()
        var password: String = passwordInicio!!.text.toString()

        val btnPositivo = { xx: DialogInterface, yy: Int ->
            val intentoADrawer = Intent(this, DrawernavActivity::class.java)
            startActivity(intentoADrawer)
            Toast.makeText(this, "Inicio exitoso", Toast.LENGTH_LONG).show()
        }
        val btnNegativo = { nombre1: DialogInterface, nombre2: Int ->
            Toast.makeText(this, "Cancelaste el ingreso", Toast.LENGTH_LONG).show()
        }
        if (username == "@2" && password == "22") {
            Toast.makeText(this, "Credenciales validas", Toast.LENGTH_LONG).show()
            val dialog = AlertDialog.Builder(this)
                .setTitle("Bienvenido $username")
                .setMessage("Estas seguro de entrar?")
                .setPositiveButton("Confirmar", btnPositivo)
                .setNegativeButton("Cancelar", btnNegativo)
                .create().show()
        } else {
            Toast.makeText(this, R.string.language_incorrect_data, Toast.LENGTH_LONG).show()
        }
    }//fin de la funcion

    //funcion para ir a registrar
    fun loginAregister(View: View)
    {
        val intentoAregister = Intent(this, RegisterActivity::class.java)
        startActivity(intentoAregister)
        Toast.makeText(this, "completa los datos", Toast.LENGTH_LONG).show()
    }

}