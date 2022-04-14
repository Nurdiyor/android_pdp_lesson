package uz.micro.star.lesson_22.app

import android.app.Application
import uz.micro.star.lesson_22.retrofit.ApiCLient

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ApiCLient.instance()
    }
}