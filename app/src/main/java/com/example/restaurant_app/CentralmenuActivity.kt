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
        setSupportActionBar(findViewById(R.id.toolbar))

        //boton fltante
        val floating: View = findViewById(R.id.floaButton)
        floating.setOnClickListener{View->
            val inten = Intent(this, MainActivity::class.java)
            startActivity(inten)
        }
    }


    //funcion llamar fracmento A
    fun llamarfragA(View:View){
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.frag_ABC_container,FragmentA::class.java,null,"Frag_A")
            .commit()
        Toast.makeText(this,"fracmento A", Toast.LENGTH_SHORT).show()
    }
    //funcion llamar fracmento B
    fun llamarfragB(View:View){
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.frag_ABC_container,FragmentB::class.java,null,"Frag_A")
            .commit()
        Toast.makeText(this,"fracmento B", Toast.LENGTH_SHORT).show()
    }
    //funcion llamar fracmento C
    fun llamarfragC(View:View){
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.frag_ABC_container,FragmentC::class.java,null,"Frag_A")
            .commit()
        Toast.makeText(this,"fracmento C", Toast.LENGTH_SHORT).show()
    }

    //funcion cerrar fracmentosss
    fun cerrarfrags(View:View){
        supportFragmentManager.findFragmentById(R.id.frag_ABC_container)?.let {
            supportFragmentManager.beginTransaction()
                .remove(it)
                .commit()
            Toast.makeText(this,"fracmento removido", Toast.LENGTH_SHORT).show()
        }
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