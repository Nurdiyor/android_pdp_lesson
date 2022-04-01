package uz.micro.star.lesson_17

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import uz.micro.star.lesson_17.database.Database

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Database.getDatabase().students.forEach {
            Log.d("RRRR", "student:${it.name} ${it.number}")
        }
        Database.getDatabase().deleteUser(4)
        Log.d("RRRR", "--------------")
        Database.getDatabase().students.forEach {
            Log.d("RRRR", "student:${it.name} ${it.number}")
        }
    }
}