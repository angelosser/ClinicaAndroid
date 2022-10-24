package pe.edu.appec02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.core.util.PatternsCompat
import pe.edu.appec02.common.AppMensaje
import pe.edu.appec02.common.TipoMensaje
import pe.edu.appec02.databinding.ActivityRegistroBinding
import java.util.regex.Pattern

class RegistroActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityRegistroBinding
    private  val listahobbies = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAcceder.setOnClickListener(this)
        binding.chxDeporte.setOnClickListener(this)
        binding.chxPintura.setOnClickListener(this)
        binding.chxOtro.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        if (p0 is CheckBox){
            agregarQuitarhobbies(p0)
        }else{
            when(p0.id){
                R.id.btnAcceder -> registroPersona()
            }
        }
    }

    private fun agregarQuitarhobbies(checkbox : CheckBox){
        if (checkbox.isChecked)
            listahobbies.add(checkbox.text.toString())
        else{
            listahobbies.remove(checkbox.text.toString())
        }
    }

    private fun setearControles(){
        listahobbies.clear()
        binding.txtDni.setText("")
        binding.txtNombre.setText("")
        binding.txtApellidos.setText("")
        binding.txtEmail.setText("")
        binding.txtPass.setText("")
        binding.radioGroup.clearCheck()
        binding.chxDeporte.isChecked = false
        binding.chxPintura.isChecked = false
        binding.chxOtro.isChecked = false
        binding.txtOtroHobby.setText("")
        binding.txtDni.isFocusableInTouchMode = true
        binding.txtDni.requestFocus()

    }

    fun validarDni() : Boolean {
        var respuesta = true
        if (binding.txtDni.text.toString().trim().isEmpty()){
            binding.txtDni.isFocusableInTouchMode = true
            binding.txtDni.requestFocus()
            respuesta = false
        }else if (binding.txtDni.text.toString().length < 8){
            binding.txtDni.isFocusableInTouchMode = true
            binding.txtDni.requestFocus()
            respuesta = false
        }
        return  respuesta
    }

    fun validarNombreApellido() : Boolean{
        var respuesta = true
        if (binding.txtNombre.text.toString().trim().isEmpty()){
            binding.txtNombre.isFocusableInTouchMode = true
            binding.txtNombre.requestFocus()
            respuesta = false
        }else if (binding.txtApellidos.text.toString().trim().isEmpty()){
            binding.txtApellidos.isFocusableInTouchMode = true
            binding.txtApellidos.requestFocus()
            respuesta = false
        }
        return respuesta
    }

    fun validarEmail() : Boolean{
        var respuesta = true
        if (binding.txtEmail.text.toString().trim().isEmpty()){
            binding.txtEmail.isFocusableInTouchMode = true
            binding.txtEmail.requestFocus()
            respuesta = false
        }else if (!PatternsCompat.EMAIL_ADDRESS.matcher(binding.txtEmail.text.toString()).matches()){
            binding.txtEmail.isFocusableInTouchMode = true
            binding.txtEmail.requestFocus()
            respuesta = false
        }
        return  respuesta
    }

    fun validarPassword() : Boolean{
        var respuesta = true
        val passforma = Pattern.compile(
            "^" +
                    "(?=.*[0-9])" +
                    "(?=\\S+$)" +
                    ".{4,}" +
                    "$"
        )
        if (binding.txtPass.text.toString().trim().isEmpty()){
            binding.txtPass.isFocusableInTouchMode = true
            binding.txtPass.requestFocus()
            respuesta = false
        }else if (!passforma.matcher(binding.txtPass.text.toString()).matches()){
            binding.txtPass.isFocusableInTouchMode = true
            binding.txtPass.requestFocus()
            respuesta = false
        }
        return  respuesta
    }

    fun validarSexo() : Boolean{
        var respuesta = true
        if (binding.radioGroup.checkedRadioButtonId == -1){
            respuesta = false
        }
        return  respuesta
    }

    fun obtenerSexo() : String {
        var sexo = ""
        when(binding.radioGroup.checkedRadioButtonId){
            R.id.rbtnHombre -> sexo = binding.rbtnHombre.text.toString()
            R.id.rbtnMujer -> sexo = binding.rbtnMujer.text.toString()
        }
        return sexo
    }

    fun validarHobbie() : Boolean{
        var respuesta = false
        if (binding.chxDeporte.isChecked || binding.chxPintura.isChecked || binding.chxOtro.isChecked || binding.txtOtroHobby.text.trim().length > 1){
            respuesta = true
        }
        return  respuesta
    }

    fun validarRegistro() : Boolean{

        var respuesta = false

        if (!validarDni()){
            AppMensaje.enviarMensaje(binding.root,
                "Ingrese 8 digitos numericos", TipoMensaje.ERROR)
        }else if (!validarNombreApellido()){
            AppMensaje.enviarMensaje(binding.root,
                "Escriba su Nombre y Apellidos", TipoMensaje.ERROR)
        }else if (!validarEmail()){
            AppMensaje.enviarMensaje(binding.root,
                "Escriba su email correctamente", TipoMensaje.ERROR)
        }else if (!validarPassword()){
            AppMensaje.enviarMensaje(binding.root,
                "Escriba la contrase;a que contenga como minimo 1 digito numerico", TipoMensaje.ERROR)
        }else if (!validarSexo()){
            AppMensaje.enviarMensaje(binding.root,
                "Seleccione un Sexo", TipoMensaje.ERROR)
        }else if (!validarHobbie()){
            AppMensaje.enviarMensaje(binding.root,
                "Seleccione o escriba sus Hobbies", TipoMensaje.ERROR)
        }else{
            respuesta = true
        }
        return respuesta
    }

    private fun registroPersona() {
        if (validarRegistro()){
            //
            AppMensaje.enviarMensaje(binding.root,"Persona Registrada Correctamente", TipoMensaje.SUCCESSFULL)
            //
            val intentLista = Intent(
                this, InformacionRegistroActivity::class.java
            ).apply {
                putExtra("listarregistro",
                    "DNI: " + binding.txtDni.text.toString() + "\n " +
                            "Nombre: " + binding.txtNombre.text.toString() + "\n " +
                            "Apellidos: " + binding.txtApellidos.text.toString() + "\n " +
                            "Email: " + binding.txtEmail.text.toString() + "\n " +
                            "Password: " + binding.txtPass.text.toString() + "\n " +
                            "Sexo: " + obtenerSexo() + "\n " +
                            "Hobbies: " +  (if (listahobbies.size == 0) binding.txtOtroHobby.text.toString()
                    else listahobbies.toString() + " " + binding.txtOtroHobby.text.toString()))
            }
            startActivity(intentLista)
            //
            setearControles()
        }
    }
}