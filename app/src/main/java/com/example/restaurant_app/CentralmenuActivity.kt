package com.example.restaurant_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

class CentralmenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_centralmenu)

    }
    //funcion menu en barra
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_barra,menu)
        return super.onCreateOptionsMenu(menu)
    }
    //funciones para los items de la barra
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when(item.itemId)
    {
        R.id.itm_Setting->{
            Toast.makeText(this,"seleccion: Configuraciones", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.itm_Close->{
            Toast.makeText(this,"seleccion: Cerrar sesion", Toast.LENGTH_SHORT).show()
            val inten = Intent(this, LoginActivity::class.java)
            startActivity(inten)
            true
        }
        else->{ super.onOptionsItemSelected(item) }
    }



}