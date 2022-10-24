package pe.edu.appec02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pe.edu.appec02.databinding.ActivityInformacionRegistroBinding

class InformacionRegistroActivity : AppCompatActivity() {

    private lateinit var binding : ActivityInformacionRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformacionRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val enviar = binding.txtResumenRegistro
        val resumen = bundle?.getString("listarregistro")

        enviar.text = resumen.toString()
    }
}