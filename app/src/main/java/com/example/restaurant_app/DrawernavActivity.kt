package com.example.restaurant_app

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.restaurant_app.databinding.ActivityDrawernavBinding
import com.google.android.material.navigation.NavigationView


class DrawernavActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDrawernavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawernav)

        setSupportActionBar(findViewById(R.id.toolbar))

        //boton flotante
        val floating: View = findViewById(R.id.fab)
        floating.setOnClickListener{View->
            Toast.makeText(this,"btn floltante", Toast.LENGTH_SHORT).show()
        }

        val drawerLayout:DrawerLayout=findViewById(R.id.drawerlayaut)
        val NavigationView:NavigationView=findViewById(R.id.nav_view)

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragment_content)as NavHostFragment
        val navController=navHostFragment.navController

        //fragmetos del drawer
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.fragmentA, R.id.fragmentB, R.id.fragmentC
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        NavigationView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragment_content)as NavHostFragment
        val navController=navHostFragment.navController
        return navController.navigateUp(appBarConfiguration)||super.onSupportNavigateUp()
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