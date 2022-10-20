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
    fun irAcentral(View: View)
    {
        val irAcentral = Intent(this, CentralmenuActivity::class.java)
        startActivity(irAcentral)
        Toast.makeText(this, "Inicia sesion o Registrate", Toast.LENGTH_LONG).show()
    }
}