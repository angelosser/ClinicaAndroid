package pe.edu.appec02

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import pe.edu.appec02.databinding.ActivityListadoBinding

class ListadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val librosmedicina = arrayOf(
            "\nTitulo: El Gran Libro del Cuerpo Humano: Segunda edición. Ampliada y actualizada \n" +
                    "\nAutor: Dr. Alice Roberts \n" +
                    "\nDescripcion: El gran libro del cuerpo humano es un libro de referencia para toda la familia, para estudiantes de anatomía y para profesionales de la medicina que desean explicar la anatomía a sus pacientes, así como un buen regalo para cualquier persona que quiera conocer en detalle cómo funciona el cuerpo humano. \n" +
                    "\nFecha de Publicacion: 25 Septiembre 2018 \n",
            "\nTitulo: SUTURE COMO UN CIRUJANO: La Guía Médica para los Nudos Quirúrgicos y las Técnicas de Sutura que se utilizan en los Departamento de Cirugía \n" +
                    "\nAutor: S. Meloni M.D., M. Mastenbjörk M.D. \n" +
                    "\nDescripcion: Este libro médico se ha creado recopilando las técnicas de sutura más importantes que necesita conocer junto con ilustraciones detalladas paso a paso que le enseñarán cómo suturar como un cirujano. Incluso encontrará preguntas al final de cada capítulo para que pueda poner a prueba sus conocimientos. \n" +
                    "\nFecha de Publicacion: 10 Marzo 2022 \n",
            "\nTitulo: La Dieta Antiinflamatoria: Haz estos cambios simples y económicos en tu dieta y comienza a sentirte mejor dentro de 24 horas! \n" +
                    "\nAutor: Jason Michaels \n" +
                    "\nDescripcion: Lo que puede que te sorprenda es que más y más estudios – incluyendo los estudios del Instituto Nacional de Alergias y Enfermedades Infecciosas (National Institute of Allergies and Infectious Diseases) – están demostrando que estos problemas de salud frecuentemente están causados por la dieta. \n" +
                    "\nFecha de Publicacion: 3 Septiembre 2018 \n",
            "\nTitulo: La revolución de la glucosa: Equilibra tus niveles de glucosa y cambiarás tu salud y tu vida \n" +
                    "\nAutor: Jessie Inchauspé \n" +
                    "\nDescripcion: Mejora todos los aspectos de tu salud, desde el peso, el sueño, los antojos, el estado de ánimo, la energía, la piel… e incluso retrasa el envejecimiento con trucos fáciles de implementar y basados en la cienc \n" +
                    "\nFecha de Publicacion: 11 Mayo 2022 \n",
            "\nTitulo: Cerebro de pan (edición revisada y actualizada): La devastadora verdad sobre los efectos del trigo, el azúcar y los carbohidratos \n" +
                    "\nAutor: David Perlmutter \n" +
                    "\nDescripcion: Cuando este libro se publicó por primera vez, no sólo conquistó rápidamente el primer puesto de todas las listas de los más vendidos alrededor del mundo, sino que inició una revolución capaz de transformar la vida de más de 1 millón de lectores. El renombrado neurólogo David Perlmutter destapa un tema que había estado enterrado en la literatura médica durante largo tiempo: los carbohidratos están destruyendo nuestro cerebro. Y no sólo los carbohidratos malos, sino aquellos considerados saludables, como los granos enteros, pueden representar amenazas a la salud con consecuencias como demencia, ansiedad, neblina cerebral, depresión, diabetes, obesidad y mucho más. \n" +
                    "\nFecha de Publicacion: 11 Abril 2019 \n",
            "\nTitulo: Los secretos de la memoria: Las historias humanas que revelaron qué es y cómo funciona la memoria \n" +
                    "\nAutor: Héctor Ruiz Martín \n" +
                    "\nDescripcion: Este libro nos adentra en una de las aventuras científicas más fascinantes en nuestro afán por descubrir quiénes somos, y lo hace a través de las historias humanas extraordinarias que nos han revelado las virtudes y los defectos de nuestro don más preciado: la memoria. Por sus páginas transitan algunos de los casos reales que han ayudado a los científicos a comprender el potencial y las limitaciones de nuestra capacidad para atesorar y rememorar el pasado, adquirir conocimientos, desarrollar habilidades, adoptar hábitos y, en definitiva, construir nuestra identidad. Porque... ¿qué  \n" +
                    "\nFecha de Publicacion: 8 Septiembre 2022 \n",
            "\nTitulo: Tratado de Cura Cuántica Estelar \n" +
                    "\nAutor: Rodrigo Romo \n" +
                    "\nDescripcion: La Cura Cuántica Estelar es un material canalizado bajo orientación de la Gran Fraternidad de Luz de los Maestros Ascendidos y del Comando Estelar con el fin de desmitificar y complementar las terapias alternativas existentes hasta entonces. En esta nueva versión, que se ha producido en 2009, presento un abordaje relativo al desarrollo y evolución de esta técnica en la última década. \n" +
                    "\nFecha de Publicacion: 14 Agosto 2019 \n",
            "\nTitulo: DMSO. Manual práctico de utilización: Libro DMSO en español, Como utilizar correctamente el DMSO, tratamientos con DMSO, aplicaciones del DMSO \n" +
                    "\nAutor: Antonio Bernal \n" +
                    "\nDescripcion: El DMSO es un producto natural, y con este libro conocerás la forma de curar a la persona de todo tipo de dolores: como musculares, de articulaciones, de cervicales, lumbalgias, fibromialgia, dolores de cabeza, de espalda, crónicos… Así como problemas digestivos y/o intestinales. Problemas emocionales, como también Ansiedad, Estrés, Insomnio, estados depresivos… \n" +
                    "\nFecha de Publicacion: 14 Octubre 2021 \n",
            "\nTitulo: Ikigai: Los secretos de Japón para una vida larga y feliz (Medicinas complementarias) \n" +
                    "\nAutor: Francesc Miralles \n" +
                    "\nDescripcion: Según los japoneses, todo el mundo tiene un ikigai, un motivo para existir. Algunos lo han encontrado y son conscientes de su ikigai, otros lo llevan dentro, pero todavía lo están buscando. Este es uno de los secretos para una vida larga, joven y feliz como la que llevan los habitantes de Okinawa, la isla más longeva del mundo.El proyecto de este libro surgió uniendo la experiencia en cultura japonesa de Héctor García (autor de Un Geek en Japón), que lleva doce años viviendo en Japón, con el arte escribiendo de Francesc Miralles (autor de decenas de libros y novelas y especialista en psicología). \n" +
                    "\nFecha de Publicacion: 20 Septiembre 2022 \n",
            "\nTitulo: Manual de medicina paliativa (Libros de medicina) \n" +
                    "\nAutor: Carlos Centeno Cortés \n" +
                    "\nDescripcion: El alivio del sufrimiento en el período final de la vida, reconocido en los últimos años como un derecho universal del ser humano, es una de las importantes misiones de la medicina. \n" +
                    "\nFecha de Publicacion: 5 Junio 2015 \n")

        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, librosmedicina)
        binding.lvlistalibros.adapter = adapter
    }
}