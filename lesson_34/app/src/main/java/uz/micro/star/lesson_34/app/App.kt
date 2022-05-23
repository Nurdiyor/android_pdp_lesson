package uz.micro.star.lesson_34.app

import android.app.Application
import uz.micro.star.lesson_34.retrofit.ApiCLient

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ApiCLient.instance()
    }
}