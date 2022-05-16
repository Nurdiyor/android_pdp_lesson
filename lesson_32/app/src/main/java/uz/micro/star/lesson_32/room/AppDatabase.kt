package uz.micro.star.lesson_32.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.micro.star.lesson_32.entities.UserEntity

@Database(
    entities = [
        UserEntity::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getInputData(): InputDao

    companion object {
        var database: AppDatabase? = null
        fun init(context: Context) {
            database = Room.databaseBuilder(
                context.applicationContext, AppDatabase::class.java, "my_room_db"
            )
                .allowMainThreadQueries()
//                .fallbackToDestructiveMigration()
                .build()
        }
    }
}