package uz.micro.star.myapplication.utils

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SharedPrefTest {
    lateinit var shared: SharedPref

    @Before
    fun init() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        shared = SharedPref(context)
    }

    @Test
    fun checkSharedUsername() {
        shared.setUsername("Sardor")
        val name = shared.getUsername()
        assertThat(name).isEqualTo("Sardor")
    }
    @Test
    fun checkSharedUsername1() {
        val name = shared.getUsername()
        assertThat(name).isNotEmpty()
    }
    @Test
    fun checkTravelName() {
        shared.setTravelName("TravelName")
        val name = shared.getTravelName()
        assertThat(name).isNotEmpty()
    }

    @Test
    fun checkIsClear() {
        shared.setTravelName("TravelName")
        shared.setTravelName("TravelName")
//        shared.clearAllData()
        val name = shared.getTravelName()
        assertThat(name).isEmpty()
    }

}