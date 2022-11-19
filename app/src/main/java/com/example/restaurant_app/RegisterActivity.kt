package com.example.restaurant_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.restaurant_app.databinding.ActivityRegisterBinding
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db: FirebaseFirestore = FirebaseFirestore.getInstance()

        // REGISTRO ----------------------------------------------------------
        binding.btnRegister.setOnClickListener{
            //tomar los datos de los editText
            val user=binding.edtRegisterUser.text.toString()
            val name=binding.edtRegisterName.text.toString()
            val email=binding.edtRegisterEmail.text.toString()
            val password=binding.edtRegisterPassword.text.toString()
            val passwordCon=binding.edtRegisterPasswordConfirm.text.toString()
            val checkR=binding.checkBoxRegister.isChecked

            if (checkR){
                if (password == passwordCon){
                    if (user.isNotBlank() && name.isNotBlank() && email.isNotBlank() && password.isNotBlank() && passwordCon.isNotBlank()){
                        // guardar informacion en el obj "datos"
                        val datos = hashMapOf(
                            "EMAIL" to email.toString(),
                            "NAME" to name.toString(),
                            "PASSWORD" to password.toString()
                        )
                        //eviar la informacion en el obj "datos" a la colleccion "DatosAppR" con el id equivalente al usuario
                        db.collection("DatosAppR")
                            .document(user.toString())
                            .set(datos)
                            .addOnSuccessListener { resul ->
                                //limpiar campos
                                binding.edtRegisterUser.text.clear()
                                binding.edtRegisterEmail.text.clear()
                                binding.edtRegisterPassword.text.clear()
                                binding.edtRegisterPasswordConfirm.text.clear()
                                // ir a login
                                val intentoAlogin = Intent(this, LoginActivity::class.java)
                                startActivity(intentoAlogin)
                                Toast.makeText(this, "Ahora puedes Iniciar sesion", Toast.LENGTH_SHORT).show()
                            }
                            .addOnFailureListener { execion ->
                                Toast.makeText(this, "Error al guardar", Toast.LENGTH_SHORT).show()
                            }
                    }else{ Toast.makeText(this, "Missing data", Toast.LENGTH_SHORT).show() }
                }else{ Toast.makeText(this, "Error! Las contraseñas deben coincidir", Toast.LENGTH_SHORT).show() }
            }else{ Toast.makeText(this, "Acceta los terminos y condiciones", Toast.LENGTH_SHORT).show() }
        }// REGISTRO ----------------------------------------------------------


    }


}