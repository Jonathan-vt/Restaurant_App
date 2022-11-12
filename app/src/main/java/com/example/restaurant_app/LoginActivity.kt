package com.example.restaurant_app

import android.content.DialogInterface
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.restaurant_app.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var UsuariosDBHelper:miSQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        UsuariosDBHelper= miSQLiteHelper(this)
        // LOGIN ----------------------------------------------------------
        binding.btnLogin.setOnClickListener{
            // varibles a validar
            val nameInicio=binding.edtInicioUser.text.toString()
            val passwInicio=binding.edtInicioPassword.text.toString()

            // la base de datos se pone en modo de leectura
            val db: SQLiteDatabase =UsuariosDBHelper.readableDatabase

            // Consulta a la base de datos local tipo SQL
            val cursor=db.rawQuery("SELECT * FROM Usuarios WHERE Usuario='"
                    + nameInicio + "' AND Contraseña='" + passwInicio + "'",null)

            if (cursor.moveToFirst()) {
                //ir a drawer navegation
                val intentoADrawer = Intent(this, DrawernavActivity::class.java)
                startActivity(intentoADrawer)
                Toast.makeText(this, "Inicio exitoso: "+cursor.getString(1).toString(), Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show()
            }
        }// LOGIN ----------------------------------------------------------


    }


    // A central
    fun Acentral(view: View)
    {
            val intentoADrawer = Intent(this, CentralmenuActivity::class.java)
            startActivity(intentoADrawer)
    }
    // A registrar
    fun loginAregister(View: View)
    {
        val intentoAregister = Intent(this, RegisterActivity::class.java)
        startActivity(intentoAregister)
        Toast.makeText(this, "completa los datos", Toast.LENGTH_SHORT).show()
    }

}

/*
//funcion para inicio de sesion anterior
fun loginAcentral(xx: View)
{
    var username: String = userInicio!!.text.toString()
    var password: String = passwordInicio!!.text.toString()

    val btnPositivo = { xx: DialogInterface, yy: Int ->
        val intentoADrawer = Intent(this, DrawernavActivity::class.java)
        startActivity(intentoADrawer)
        Toast.makeText(this, "Inicio exitoso", Toast.LENGTH_SHORT).show()
    }
    val btnNegativo = { nombre1: DialogInterface, nombre2: Int ->
        Toast.makeText(this, "Cancelaste el ingreso", Toast.LENGTH_SHORT).show()
    }
    if (username == "@2" && password == "22") {
        Toast.makeText(this, "Credenciales validas", Toast.LENGTH_SHORT).show()
        val dialog = AlertDialog.Builder(this)
            .setTitle("Bienvenido $username")
            .setMessage("Estas seguro de entrar?")
            .setPositiveButton("Confirmar", btnPositivo)
            .setNegativeButton("Cancelar", btnNegativo)
            .create().show()
    } else {
        Toast.makeText(this, R.string.language_incorrect_data, Toast.LENGTH_SHORT).show()
    }
}
*/