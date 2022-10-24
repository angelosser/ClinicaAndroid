package pe.edu.appec02.common
import android.app.Application

class MiApp: Application() {
    companion object{
        lateinit var  instance : MiApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}