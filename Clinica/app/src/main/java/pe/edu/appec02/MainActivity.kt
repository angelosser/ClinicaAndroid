package pe.edu.appec02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.appec02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener  {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistro.setOnClickListener (this)
        binding.btnFormulario.setOnClickListener(this)
        binding.btnListado.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btnRegistro ->{
                RegistroFrm()
            }

            R.id.btnFormulario ->{
                FormularioFrm()
            }

            R.id.btnListado ->{
                ListadoFrm()
            }
        }
    }

    fun RegistroFrm(){
        val i = Intent (this, RegistroActivity::class.java)
        startActivity(i)
    }

    fun FormularioFrm(){
        val i = Intent( this, FormularioActivity::class.java)
        startActivity(i)
    }

    fun ListadoFrm(){
        val i = Intent( this, ListadoActivity::class.java)
        startActivity(i)
    }
}