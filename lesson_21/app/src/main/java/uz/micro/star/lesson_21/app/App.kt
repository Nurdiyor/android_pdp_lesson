package uz.micro.star.lesson_21.app

import android.app.Application
import uz.micro.star.lesson_21.retrofit.ApiCLient

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ApiCLient.instance()
    }
}