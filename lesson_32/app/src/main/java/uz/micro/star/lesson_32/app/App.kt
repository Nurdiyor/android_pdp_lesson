package uz.micro.star.lesson_32.app

import android.app.Application
import uz.micro.star.lesson_32.room.AppDatabase

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        AppDatabase.init(this)
    }
}