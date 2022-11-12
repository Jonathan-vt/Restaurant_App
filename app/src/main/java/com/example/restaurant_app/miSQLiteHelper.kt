package com.example.restaurant_app

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// herecia de SQLITEOPENHELPER
class miSQLiteHelper(context: Context):SQLiteOpenHelper(context, "UsuariosDB",null,1) {

    //crear tabla
    override fun onCreate(db: SQLiteDatabase?) {
        val ordenCreacion="CREATE TABLE Usuarios"+
                "(key_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "Usuario TEXT, Correo TEXT, Contraseña TEXT)"
        db!!.execSQL(ordenCreacion)
    }
    // poner los datos de Usuarios en db
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenBorrado="DROP TABLE IF EXISTS Usuarios"
        db!!.execSQL(ordenBorrado)
        onCreate(db)
    }
    //guardar un datos
    fun GuardarDatos(Usuario:String,Correo:String,Contraseña:String){
        val datos=ContentValues() //mainipulacion de datos Clave Valor
        datos.put("user",Usuario)
        datos.put("email",Correo)
        datos.put("password",Contraseña)

        val db=this.writableDatabase // la base de datos se pone en modo de escritura
        db.insert("Usuarios",null,datos)
        db.close()
    }
    //eliminar un dato
    fun EliminarDato(id:Int):Int{
        val args = arrayOf(id.toString())
        val db = this.writableDatabase // la base de datos se pone en modo de escritura
        val borrardato=db.delete("Usuarios","key_id=?",args)
        db.close()

        return borrardato // devuele el numero de elementos borrados
    }
    //editar dato
    fun editarDato(id:Int, Usuario:String, Correo:String, Contraseña:String){
        val args = arrayOf(id.toString())

        val datos=ContentValues() //Nuevos parametros para actualizar
        datos.put("user",Usuario)
        datos.put("email",Correo)
        datos.put("password",Contraseña)
        val db=writableDatabase // la base de datos se pone en modo de escritura
        db.update("Usuarios",datos,"key_id=?",args)
        db.close()
    }

}