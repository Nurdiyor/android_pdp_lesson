package uz.micro.star.myapplication.utils

import java.util.*

class MyUtils {

    fun max(a: Int, b: Int): Int {
        if (a == b) {
            throw Exception()
        }
        return if (a > b) a else b
    }

    fun min(a: Int, b: Int): Int {
        if (a == b) {
            throw Exception()
        }
        return if (a < b) a else b
    }

    fun toUpperCase(name: String) = name.uppercase(Locale.getDefault())
}