package modelo

import android.telecom.Connection
import java.sql.DriverManager

class ClaseConexion {
    fun cadenaConexion(): java.sql.Connection? {
       try {
           val url = "jdbc:oracle:thin:@10.10.1.120:1521:xe"
           val usuario = "system"
           val contraseña = "ITR2024"

           val connection = DriverManager.getConnection(url, usuario, contraseña)
           return connection
       }
       catch (e: Exception){
           println("error: $e")
           return null
       }
    }
}