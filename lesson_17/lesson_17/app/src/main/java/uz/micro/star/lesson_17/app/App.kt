package uz.micro.star.lesson_17.app

import android.app.Application
import uz.micro.star.lesson_17.database.Database

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Database.init(this).createDatabase().open()
    }

    override fun onTerminate() {
        Database.getDatabase().close()
        super.onTerminate()
    }
}