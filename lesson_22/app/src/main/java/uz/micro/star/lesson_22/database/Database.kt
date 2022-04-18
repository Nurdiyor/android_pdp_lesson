package uz.micro.star.lesson_22.database

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import uz.micro.star.lesson_22.libs.DataBaseHelper
import uz.micro.star.lesson_22.models.TrainerDbModel
import java.io.IOException

class Database(private val mContext: Context?) {
    private val mDbHelper: DataBaseHelper = DataBaseHelper(mContext)
    private var mDb: SQLiteDatabase? = null
    fun createDatabase(): Database {
        try {
            mDbHelper.createDataBase()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return this
    }

    @Throws(SQLException::class)
    fun open(): Database {
        mDb = try {
            mDbHelper.openDataBase()
            mDbHelper.close()
            mDbHelper.readableDatabase
        } catch (mSQLException: SQLException) {
            Log.e(TAG, "open >>$mSQLException")
            throw mSQLException
        }
        return this
    }

    fun close() {
        mDbHelper.close()
    }

    fun getFavouriteWords(query: String): Cursor? {
        return mDb!!.rawQuery(
            "SELECT * FROM data WHERE favourite = 1 AND word LIKE ?", arrayOf(
                "$query%"
            )
        )
    }

    //1-add
    //2-update
    //3-delete
    //0-is not change
    @get:SuppressLint("Range")
    val getTrainersList: ArrayList<TrainerDbModel>
        get() {
            val data: ArrayList<TrainerDbModel> = ArrayList()
            val cursor = mDb!!.rawQuery("select * from trainer where change_type!=3", null)
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                data.add(
                    TrainerDbModel(
                        cursor.getInt(cursor.getColumnIndex("trainer_id")),
                        cursor.getInt(cursor.getColumnIndex("change_type")),
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("trainer_name")),
                        cursor.getString(cursor.getColumnIndex("trainer_surname")),
                        cursor.getDouble(cursor.getColumnIndex("trainer_salary"))
                    )
                )
                cursor.moveToNext()
            }
            cursor.close()
            return data
        }

    @get:SuppressLint("Range")
    val getChangedTrainersList: ArrayList<TrainerDbModel>
        get() {
            val data: ArrayList<TrainerDbModel> = ArrayList()
            val cursor = mDb!!.rawQuery("select * from trainer where change_type!=0", null)
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                data.add(
                    TrainerDbModel(
                        cursor.getInt(cursor.getColumnIndex("trainer_id")),
                        cursor.getInt(cursor.getColumnIndex("change_type")),
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("trainer_name")),
                        cursor.getString(cursor.getColumnIndex("trainer_surname")),
                        cursor.getDouble(cursor.getColumnIndex("trainer_salary"))
                    )
                )
                cursor.moveToNext()
            }
            cursor.close()
            return data
        }

    ///////////delete by id
    fun deleteTrainer(id: Int): Int {
        return mDb!!.delete("trainer", "trainer_id=$id", null)
    }

    fun deleteAllTrainer(): Int {
        return mDb!!.delete("trainer", "change_type=0", null)
    }

    /////add new user////////////////
    fun addTrainer(userData: TrainerDbModel): TrainerDbModel {
        val values = ContentValues()
        values.put("change_type", userData.changeType)
        values.put("id", userData.id)
        values.put("trainer_name", userData.trainerName)
        values.put("trainer_surname", userData.trainerSurname)
        values.put("trainer_salary", userData.trainerSalary)
        val id = mDb!!.insert("trainer", null, values)
        userData.trainerId = id.toInt()
        return userData
    }

    /////for edit user
    fun editTrainer(trainer: TrainerDbModel) {
        val values = ContentValues()
        values.put("change_type", trainer.changeType)
        values.put("id", trainer.id)
        values.put("trainer_name", trainer.trainerName)
        values.put("trainer_surname", trainer.trainerSurname)
        values.put("trainer_salary", trainer.trainerSalary)
        mDb!!.update("trainer", values, "trainer_id=" + trainer.trainerId, null)
    }

    companion object {
        private const val TAG = "TAG"
        var database: Database? = null
            private set

        fun init(context: Context?): Database? {
            if (database == null) {
                database = Database(context)
            }
            return database
        }
    }

}