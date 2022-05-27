package uz.micro.star.lesson_34.app

import android.app.Application
import uz.micro.star.lesson_34.room.AppDatabase
import uz.micro.star.lesson_34.retrofit.ApiCLient

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AppDatabase.init(this)
        ApiCLient.instance()
    }
}