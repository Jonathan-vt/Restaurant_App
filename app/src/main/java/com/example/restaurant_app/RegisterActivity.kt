package com.example.restaurant_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.restaurant_app.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    lateinit var UsuariosDBHelper:miSQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        UsuariosDBHelper= miSQLiteHelper(this)

        binding.btnRegister.setOnClickListener{

            val user=binding.edtRegisterUser.text.toString()
            val email=binding.edtRegisterEmail.text.toString()
            val password=binding.edtRegisterEmail.text.toString()

            if (user.isNotBlank() && email.isNotBlank() && password.isNotBlank()){

                UsuariosDBHelper.GuardarDatos(user,email,password)

                binding.edtRegisterUser.text.clear()
                binding.edtRegisterEmail.text.clear()
                binding.edtRegisterPassword.text.clear()
                binding.edtRegisterPasswordConfirm.text.clear()
                Toast.makeText(this, "Guardado con exito", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Datos faltantes", Toast.LENGTH_SHORT).show()
            }
        }


    }

    fun registroAlogin(View: View)
    {
        val intentoAlogin = Intent(this, LoginActivity::class.java)
        startActivity(intentoAlogin)
        Toast.makeText(this, "Inicia sesion", Toast.LENGTH_LONG).show()
    }
}