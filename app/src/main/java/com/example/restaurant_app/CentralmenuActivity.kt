package com.example.restaurant_app

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.restaurant_app.databinding.ActivityCentralmenuBinding
import com.example.restaurant_app.databinding.ActivityLoginBinding

class CentralmenuActivity : AppCompatActivity() {
    lateinit var binding:ActivityCentralmenuBinding
    lateinit var UsuariosDBHelper:miSQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCentralmenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        UsuariosDBHelper= miSQLiteHelper(this)
        // Listar ----------------------------------------------------------
        binding.buttonBase.setOnClickListener{
            Toast.makeText(this,"Listar usuarios", Toast.LENGTH_SHORT).show()

            binding.textViewBase.text=""
            val db:SQLiteDatabase=UsuariosDBHelper.readableDatabase
            val cursor=db.rawQuery("SELECT * FROM Usuarios",null)

            if (cursor.moveToFirst())
                do {
                    binding.textViewBase.append(cursor.getInt(0).toString()+" -- ID ")
                    binding.textViewBase.append(cursor.getString(1).toString()+" -- Nombre ")
                    binding.textViewBase.append(cursor.getString(2).toString()+" -- Correo \n ")
                }while (cursor.moveToNext())
        }// Listar ----------------------------------------------------------


    }


}