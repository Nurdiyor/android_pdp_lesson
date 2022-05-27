package uz.micro.star.lesson_34.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.micro.star.lesson_34.room.entities.TrainerEntity
import uz.micro.star.lesson_34.utils.Migrations

@Database(
    entities = [
        TrainerEntity::class
    ],
    version = 2
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
                .addMigrations(Migrations.salaryColumnChange)
//                .addMigrations(Migrations.nimadir)
//                .fallbackToDestructiveMigration()
                .build()
        }
    }
}