package uz.micro.star.lesson_34.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TrainerEntity(
    @PrimaryKey
    var id: Int,
    var trainerName: String,
    var salary: Double,
    var trainerSurname: String,
)