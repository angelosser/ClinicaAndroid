package pe.edu.appec02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.appec02.databinding.ActivityInformacionFormularioBinding
import pe.edu.appec02.databinding.ActivityInformacionRegistroBinding

class InformacionFormularioActivity : AppCompatActivity() {

    private lateinit var binding : ActivityInformacionFormularioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformacionFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val enviar = binding.txtResumenFormulario
        val datos = bundle?.getString("listarformulario")

        enviar.text = datos.toString()
    }

}