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
            val intentoAcentral = Intent(this, CentralmenuActivity::class.java)
            startActivity(intentoAcentral)
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
    //funcion cerrar fracments en A
    fun cerrarfragsA(View:View){
        supportFragmentManager.findFragmentById(R.id.frag_A_container)?.let {
            supportFragmentManager.beginTransaction()
                .remove(it)
                .commit()
            Toast.makeText(this,"fracmento removido", Toast.LENGTH_SHORT).show()
        }
    }
    //funcion llamar fracmento A_01
    fun llamarFragA01(View:View){
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.frag_A_container,A_01Fragment::class.java,null,"Frag_B")
            .commit()
        Toast.makeText(this,"fracmento A1", Toast.LENGTH_SHORT).show()
    }
    //funcion cerrar fracments en B
    fun cerrarfragsB(View:View){
        supportFragmentManager.findFragmentById(R.id.frag_B_container)?.let {
            supportFragmentManager.beginTransaction()
                .remove(it)
                .commit()
            Toast.makeText(this,"fracmento removido", Toast.LENGTH_SHORT).show()
        }
    }
    //funcion llamar fracmento B_01
    fun llamarFragB01(View:View){
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.frag_B_container,B_01Fragment::class.java,null,"Frag_B")
            .commit()
        Toast.makeText(this,"fracmento B1", Toast.LENGTH_SHORT).show()
    }
    //funcion cerrar fracments en C
    fun cerrarfragsC(View:View){
        supportFragmentManager.findFragmentById(R.id.frag_C_container)?.let {
            supportFragmentManager.beginTransaction()
                .remove(it)
                .commit()
            Toast.makeText(this,"fracmento removido", Toast.LENGTH_SHORT).show()
        }
    }
    //funcion llamar fracmento C_01
    fun llamarFragC01(View:View){
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.frag_C_container,C_01Fragment::class.java,null,"Frag_B")
            .commit()
        Toast.makeText(this,"fracmento C1", Toast.LENGTH_SHORT).show()
    }
}