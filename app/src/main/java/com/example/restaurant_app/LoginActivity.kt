package com.example.restaurant_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurant_app.databinding.ActivityLoginBinding
import com.google.firebase.firestore.FieldPath
import com.google.firebase.firestore.FirebaseFirestore

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db: FirebaseFirestore = FirebaseFirestore.getInstance()

        // LOGIN -----------------------------------------------------------------------------------
        binding.btnLogin.setOnClickListener {
            // varibles a validar
            val nameInicio = binding.edtInicioUser.text.toString()
            val passwInicio = binding.edtInicioPassword.text.toString()

            if (nameInicio.isNotBlank() && passwInicio.isNotBlank()) {

                db.collection("DatosAppR")
                    .document(nameInicio)
                    .get()
                    .addOnSuccessListener {

                        //obtener los datos de "it"
                        val passwBaseD = it.get("PASSWORD") as String?
                        val nameBaseD = it.get("NAME") as String?
                        val correoBaseD = it.get("EMAIL") as String?

                        if (passwInicio == passwBaseD) {

                            //ir a drawer navegation
                            val intentoADrawer = Intent(this, DrawernavActivity::class.java)
                            startActivity(intentoADrawer)
                            Toast.makeText(this, "WELCOM "+nameBaseD.toString(), Toast.LENGTH_SHORT).show()

                        }else { Toast.makeText(this, "Error! data incorret", Toast.LENGTH_SHORT).show() }
                    }
                    .addOnFailureListener{
                        Toast.makeText(this, "User not exist in data base", Toast.LENGTH_SHORT).show()
                    }

            } else { Toast.makeText(this, "Missing data", Toast.LENGTH_SHORT).show() }
        }// fin LOGIN --------------------------------------------------------------------------------


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
        Toast.makeText(this, "completa los campos", Toast.LENGTH_SHORT).show()
    }


}
