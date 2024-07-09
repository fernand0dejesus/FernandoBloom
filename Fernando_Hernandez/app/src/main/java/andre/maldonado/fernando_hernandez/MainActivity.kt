package andre.maldonado.fernando_hernandez

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import modelo.ClaseConexion

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1- Mandar a llamar a todos los elementos de la vista
        val txtId = findViewById<EditText>(R.id.txtId)
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtTipoSangre = findViewById<EditText>(R.id.txtTipoSangre)
        val txtTelefono = findViewById<EditText>(R.id.txtTelefono)
        val txtEnfermedad = findViewById<EditText>(R.id.txtEnfermedad)
        val txtFechaNacimiento = findViewById<EditText>(R.id.txtFechaNacimiento)
        val txtHabitacion = findViewById<EditText>(R.id.txtHabitacion)
        val btnAgregarPaciente = findViewById<Button>(R.id.btnAgregarPaciente)


        //2- Programar el boton agregar paciente
        btnAgregarPaciente.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                //1-crear un objeto de la clase  conexion

                val objConexion = ClaseConexion().cadenaConexion()

                //2- crear una variable que contenga un prepare statement
                val addPaciente = objConexion?.prepareStatement("insert into Pacientes (PacienteID, Nombre, TipoSangre, Telefono, Enfermedad, FechaNacimiento, HabitacionID) values(?,?,?,?,?,?,?)")!!

                

            }
        }
    }
}