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
        // REGISTRO ----------------------------------------------------------
        binding.btnRegister.setOnClickListener{

            val user=binding.edtRegisterUser.text.toString()
            val email=binding.edtRegisterEmail.text.toString()
            val password=binding.edtRegisterPassword.text.toString()
            val passwordCon=binding.edtRegisterPasswordConfirm.text.toString()
            val checkR=binding.checkBoxRegister.isChecked

            if (checkR){
                if (password == passwordCon){
                    if (user.isNotBlank() && email.isNotBlank() && password.isNotBlank() && passwordCon.isNotBlank()){
                        // guardar datos
                        UsuariosDBHelper.GuardarDatos(user,email,password)

                        //limpiar campos
                        binding.edtRegisterUser.text.clear()
                        binding.edtRegisterEmail.text.clear()
                        binding.edtRegisterPassword.text.clear()
                        binding.edtRegisterPasswordConfirm.text.clear()
                        Toast.makeText(this, "Guardado con exito", Toast.LENGTH_SHORT).show()

                        // ir a login
                        val intentoAlogin = Intent(this, LoginActivity::class.java)
                        startActivity(intentoAlogin)
                        Toast.makeText(this, "Ahora Inicia sesion", Toast.LENGTH_SHORT).show()

                    }else{
                        Toast.makeText(this, "Datos faltantes", Toast.LENGTH_SHORT).show() }
                }else{
                    Toast.makeText(this, "Error! Las contraseñas deben coincidir", Toast.LENGTH_SHORT).show() }
            }else{
                Toast.makeText(this, "Acceta los terminos y condiciones", Toast.LENGTH_SHORT).show() }
        }// REGISTRO ----------------------------------------------------------


    }

    // ir a login anterior
    fun registroAlogin(View: View)
    {
        val intentoAlogin = Intent(this, LoginActivity::class.java)
        startActivity(intentoAlogin)
        Toast.makeText(this, "Ahora Inicia sesion", Toast.LENGTH_SHORT).show()
    }
}