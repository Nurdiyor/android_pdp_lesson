package uz.micro.star.myapplication.room

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class UserDbTest {
    lateinit var db: UserDb
    lateinit var dao: UserDao

    @Before
    fun init() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, UserDb::class.java).build()
        dao = db.getUserDao()
    }

    @After
    fun closeDB() {
        db.close()
    }

    @Test
    fun writeReadSpendTest() = runBlocking {
        val user1 = User("Aziz", "+0987654567890", Date())
        dao.addUser(user1)
        val spends = dao.getUsers()
        assertThat(spends).contains(user1)
    }


}