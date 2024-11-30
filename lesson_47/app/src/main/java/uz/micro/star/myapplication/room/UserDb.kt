package uz.micro.star.myapplication.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [User::class], version = 1)
@TypeConverters(DateConverter::class)
abstract  class UserDb : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {
        private const val DB_NAME = "Spends-Database.db"

        @Volatile
        private var instance: UserDb? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            UserDb::class.java,
            DB_NAME
        ).fallbackToDestructiveMigration().build()
    }
}