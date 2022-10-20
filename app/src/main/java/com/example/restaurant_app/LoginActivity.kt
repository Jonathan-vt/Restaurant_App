package com.example.restaurant_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    fun loginAcentral(View: View)
    {
        val loginAcentral = Intent(this, CentralmenuActivity::class.java)
        startActivity(loginAcentral)
        Toast.makeText(this, "Inicia sesion o Registrate", Toast.LENGTH_LONG).show()
    }
    fun loginAregister(View: View)
    {
        val loginAregister = Intent(this, CentralmenuActivity::class.java)
        startActivity(loginAregister)
        Toast.makeText(this, "Inicia sesion o Registrate", Toast.LENGTH_LONG).show()
    }
}