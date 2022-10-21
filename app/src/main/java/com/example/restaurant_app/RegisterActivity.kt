package com.example.restaurant_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
    fun registroAlogin(View: View)
    {
        val intentoAlogin = Intent(this, LoginActivity::class.java)
        startActivity(intentoAlogin)
        Toast.makeText(this, "Inicia sesion", Toast.LENGTH_LONG).show()
    }
}