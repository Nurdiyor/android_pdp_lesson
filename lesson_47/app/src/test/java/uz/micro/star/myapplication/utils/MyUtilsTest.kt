package uz.micro.star.myapplication.utils

import org.junit.After
import org.junit.Before
import org.junit.Test
import com.google.common.truth.Truth.assertThat
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MyUtilsTest {
    lateinit var myUtils: MyUtils

    @Before
    fun initialize() {
        myUtils = MyUtils()

    }

    @Test
    fun max1() {
        assertThat(myUtils.max(2,6)).isEqualTo(6)
    }

    @Test
    fun max2() {
        assertThat(myUtils.max(2,6)).isEqualTo(2)
    }

    @Test
    fun max3() {
        assertThat(myUtils.max(12,6)).isEqualTo(12)
    }

    @Test
    fun min1() {
        assertThat(myUtils.min(2,6)).isEqualTo(2)
    }

    @Test
    fun min2() {
        assertThat(myUtils.min(2,6)).isEqualTo(6)
    }

    @Test
    fun min33() {
        assertThat(myUtils.min(6,6)).isEqualTo(6)
    }

    @Test
    fun toUpperCase1() {
        assertThat(myUtils.toUpperCase("Helo")).isEqualTo("HELO")
    }

    @Test
    fun toUpperCase2() {
        assertThat(myUtils.toUpperCase("Helo")).isEqualTo("Helo")
    }

    @Test
    fun toUpperCase3() {
        assertThat(myUtils.toUpperCase("Helo")).isEqualTo("HElO")
    }

    @After
    fun close() {
        //nimadir
    }
}