package uz.micro.star.lesson_17.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import uz.micro.star.lesson_17.libs.DataBaseHelper;
import uz.micro.star.lesson_17.models.Student;

/**
 * Created by Microstar on 21.05.2019.
 */

public class Database {
    private static final String TAG = "TAG";
    private static Database database;
    private final Context mContext;
    private final DataBaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    public Database(Context mContext) {
        this.mContext = mContext;
        mDbHelper = new DataBaseHelper(mContext);
    }

    public static Database init(Context context) {
        if (database == null) {
            database = new Database(context);
        }
        return database;
    }

    public static Database getDatabase() {
        return database;
    }

    public Database createDatabase() {
        try {
            mDbHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Database open() throws SQLException {
        try {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();
        } catch (SQLException mSQLException) {
            Log.e(TAG, "open >>" + mSQLException);
            throw mSQLException;
        }
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    @SuppressLint("Range")
    public ArrayList<Student> getStudents() {
        ArrayList<Student> data = new ArrayList<>();
        Cursor cursor = mDb.rawQuery("select * from Student", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            data.add(new Student(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getString(cursor.getColumnIndex("number")),
                    cursor.getInt(cursor.getColumnIndex("group_id"))
            ));
            cursor.moveToNext();
        }
        cursor.close();
        return data;
    }

    ///////////delete by id
    public void deleteUser(int id) {
        mDb.delete("Student", "id=" + id, null);
    }

    /////add new user////////////////
    public void addUser(Student userData) {
        ContentValues values = new ContentValues();
        values.put("name", userData.getName());
        values.put("number", userData.getNumber());
        values.put("group_id", userData.getGroupId());
        long id = mDb.insert("Student", null, values);
//        long id2 = mDb.rawQuery("insert into Student(n)")
        userData.setId((int) id);
    }

    /////for edit user
    public void editUser(Student userData) {
        ContentValues values = new ContentValues();
        values.put("name", userData.getName());
        values.put("number", userData.getNumber());
        values.put("group_id", userData.getGroupId());
        mDb.update("Student", values, "id=" + userData.getId(), null);
    }

}