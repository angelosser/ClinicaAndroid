package pe.edu.appec02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import pe.edu.appec02.common.AppMensaje
import pe.edu.appec02.common.TipoMensaje
import pe.edu.appec02.databinding.ActivityFormularioBinding
import pe.edu.appec02.databinding.ActivityInformacionFormularioBinding
import pe.edu.appec02.databinding.ActivityMainBinding

class FormularioActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityFormularioBinding
    private var listadoSintomas = ArrayList<String>()
    private var listadoServicios = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormularioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnResolver.setOnClickListener(this)
        binding.chxDisminucion.setOnClickListener(this)
        binding.chxTos.setOnClickListener(this)
        binding.chxDolor.setOnClickListener(this)
        binding.chxCongestion.setOnClickListener(this)
        binding.chxFiebre.setOnClickListener(this)
        binding.chxNinguno.setOnClickListener(this)
        binding.chxLuz.setOnClickListener(this)
        binding.chxAgua.setOnClickListener(this)
        binding.chxInternet.setOnClickListener(this)
        binding.chxCable.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        if (p0 is CheckBox){
            agregarQuitarServicios(p0);
            agregarQuitarSintomas(p0);
        }else{
            when(p0.id){
                R.id.btnResolver -> registroFormulario()
            }
        }
    }

    private fun setearControles() {
        listadoServicios.clear()
        listadoSintomas.clear()
        binding.RadioGroupAdulto.clearCheck()
        binding.RadioGroupGrado.clearCheck()
        binding.RadioGroupVive.clearCheck()
        binding.chxDisminucion.isChecked = false
        binding.chxTos.isChecked = false
        binding.chxDolor.isChecked = false
        binding.chxCongestion.isChecked = false
        binding.chxFiebre.isChecked = false
        binding.chxNinguno.isChecked = false
        binding.chxLuz.isChecked = false
        binding.chxAgua.isChecked = false
        binding.chxInternet.isChecked = false
        binding.chxCable.isChecked = false
    }

    private fun agregarQuitarSintomas(checkbox : CheckBox){
        var sintomas = ArrayList<String>()
        if(binding.chxNinguno.isChecked || binding.chxCongestion.isChecked || binding.chxFiebre.isChecked ||
            binding.chxDolor.isChecked || binding.chxDisminucion.isChecked  || binding.chxTos.isChecked  ) {
            listadoSintomas.add(checkbox.text.toString())
        }
        if (binding.chxNinguno.isChecked){
            sintomas.add(binding.chxNinguno.text.toString())
        }
        if (binding.chxCongestion.isChecked){
            sintomas.add(binding.chxCongestion.text.toString())
        }
        if (binding.chxFiebre.isChecked){
            sintomas.add(binding.chxFiebre.text.toString())
        }
        if (binding.chxDolor.isChecked){
            sintomas.add(binding.chxDolor.text.toString())
        }
        if (binding.chxDisminucion.isChecked){
            sintomas.add(binding.chxDisminucion.text.toString())
        }
        if (binding.chxTos.isChecked){
            sintomas.add(binding.chxTos.text.toString())
        }
        listadoSintomas = sintomas
    }

    private fun agregarQuitarServicios(checkbox : CheckBox){
        var servicios = ArrayList<String>()

        if (binding.chxLuz.isChecked){
            servicios.add(binding.chxLuz.text.toString())
        }
        if (binding.chxInternet.isChecked){
            servicios.add(binding.chxInternet.text.toString())
        }
        if (binding.chxCable.isChecked){
            servicios.add(binding.chxCable.text.toString())
        }
        if (binding.chxAgua.isChecked){
            servicios.add(binding.chxAgua.text.toString())
        }

        listadoServicios = servicios
    }

    fun validarSintomas(): Boolean {
        var respuesta = false;
        if(listadoSintomas.size > 0) {
            respuesta = true;
        }
        return respuesta;
    }

    fun validarFiebre(): Boolean {
        var respuesta = false;
        if(binding.rbtnSiFiebre.isChecked || binding.rbtnNoFiebre.isChecked) {
            respuesta = true;
        }
        return respuesta;
    }

    fun validarVivirSolo(): Boolean {
        var respuesta = false;
        if(binding.rbtnSiCasa.isChecked || binding.rbtnNoCasa.isChecked) {
            respuesta = true;
        }
        return respuesta;
    }

    fun validarAdulto(): Boolean {
        var respuesta = false;
        if(binding.rbtnSiAdulto.isChecked || binding.rbtnNoAdulto.isChecked) {
            respuesta = true;
        }
        return respuesta;
    }

    fun ObtenerFiebre(): String {
        var fiebre = "";
        when(binding.RadioGroupGrado.checkedRadioButtonId) {
            R.id.rbtnSiFiebre -> fiebre = "Si";
            R.id.rbtnNoFiebre -> fiebre = "No";
        }
        return fiebre;
    }

    fun ObtenerVivirSolo(): String {
        var vive = "";
        when(binding.RadioGroupVive.checkedRadioButtonId) {
            R.id.rbtnSiCasa -> vive = "Si";
            R.id.rbtnNoCasa -> vive = "No";
        }
        return vive;
    }

    fun ObtenerAdulto(): String {
        var adulto = "";
        when(binding.RadioGroupAdulto.checkedRadioButtonId) {
            R.id.rbtnSiAdulto -> adulto = "Si";
            R.id.rbtnNoAdulto -> adulto = "No";
        }
        return adulto;
    }

    fun validarRegistro() : Boolean{

        var respuesta = false

        if (!validarSintomas()){
            AppMensaje.enviarMensaje(binding.root,
                "Indique los sintomas", TipoMensaje.ERROR)
        }else if (!validarFiebre()){
            AppMensaje.enviarMensaje(binding.root,
                "Indique estado de la fiebre", TipoMensaje.ERROR)
        }else if (!validarVivirSolo()){
            AppMensaje.enviarMensaje(binding.root,
                "Elija si vive solo(a)", TipoMensaje.ERROR)
        }else if (!validarAdulto()){
            AppMensaje.enviarMensaje(binding.root,
                "Marque si vive con adulto mayor", TipoMensaje.ERROR)
        }else{
            respuesta = true
        }
        return respuesta
    }

    private fun registroFormulario() {
        if (validarRegistro()){
            AppMensaje.enviarMensaje(binding.root,"Formulario registrado", TipoMensaje.SUCCESSFULL)
            val i = Intent(
                this, InformacionFormularioActivity::class.java
            ).apply {
                putExtra("listarformulario",
                    "Síntomas: " + listadoSintomas.toString() + "\n " +
                            "Fiebre: " + ObtenerFiebre() + "\n " +
                            "Vivir Solo: " + ObtenerVivirSolo() + "\n " +
                            "Vivir c Adulto Mayor: " + ObtenerAdulto() + "\n " +
                            "Servicios: " +  (if (listadoServicios.size == 0) "No tiene servicios basicos" else listadoServicios.toString()))
            }
            startActivity(i)
            setearControles()
        }
    }
}