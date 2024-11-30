package uz.micro.star.myapplication.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class User(val name: String, val number: String, val dof: Date) {
    @PrimaryKey
    var id: Long = 0
}