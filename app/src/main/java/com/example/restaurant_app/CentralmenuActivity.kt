package com.example.restaurant_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

class CentralmenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_centralmenu)
        setSupportActionBar(findViewById(R.id.toolbar))
    }


    //funcion menu en barra

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_barra,menu)
        return super.onCreateOptionsMenu(menu)
    }

}