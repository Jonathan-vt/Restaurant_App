package com.example.restaurant_app

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurant_app.databinding.ActivityCentralmenuBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CentralmenuActivity : AppCompatActivity() {

    lateinit var binding:ActivityCentralmenuBinding
    lateinit var UsuariosDBHelper:miSQLiteHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCentralmenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //---------------------------------------------------------------------------------------
        val db: FirebaseFirestore = FirebaseFirestore.getInstance()
        //consultar todos los datos en la coleccion DatosAppR
        binding.buttonFirebase.setOnClickListener {

            var datos = ""

            db.collection("DatosAppR")
                .get().addOnSuccessListener { listadatos ->
                    for (documeto in listadatos) {
                        datos += "${documeto.id}:${documeto.data}\n\n"
                    }
                    binding.textViewFirebase.text = datos
                }
                .addOnFailureListener {
                    binding.textViewFirebase.text = "Fallo"
                }
        }

        //---------------------------------------------------------------------------------------

        // base de datos local
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