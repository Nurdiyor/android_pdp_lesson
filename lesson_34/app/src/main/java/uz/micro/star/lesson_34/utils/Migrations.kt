package uz.micro.star.lesson_34.utils

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object Migrations {
    var salaryColumnChange = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE TrainerEntity RENAME COLUMN trainerSalary TO salary")
        }
    }
    var nimadir = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE TrainerEntity RENAME COLUMN trainerSalary TO salary")
        }
    }
}
