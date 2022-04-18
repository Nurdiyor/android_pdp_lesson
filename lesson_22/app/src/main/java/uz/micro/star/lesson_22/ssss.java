package uz.micro.star.lesson_22;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import uz.xsoft.lesson17ict4.libs.DBHelper;
import uz.xsoft.lesson17ict4.models.WordData;


/**
 * Created by Sherzodbek on 19.05.2018 in Lesson15ICT4.
 */
public class Database extends DBHelper {
    private static Database database;

    public static void init(Context context) {
        if (database == null) {
            database = new Database(context);
        }
    }

    public static Database getDatabase() {
        return database;
    }

    private Database(Context context) {
        super(context, "words.db");
    }

    public Cursor getFavouriteWords(String query) {
        return database().rawQuery("SELECT * FROM data WHERE favourite = 1 AND word LIKE ?", new String[]{query + "%"});
    }

    public Cursor getWords(String query) {
        return database().rawQuery("SELECT * FROM data WHERE word LIKE ?", new String[]{query + "%"});
    }

    public void setFavourite(WordData data) {
        ContentValues values = new ContentValues();
        values.put("favourite", data.getFavourite());
        database().update("data", values, "_id=" + data.getId(), null);
    }
}
