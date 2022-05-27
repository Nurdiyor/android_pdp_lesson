package uz.micro.star.lesson_34.retrofit.models.response

import com.google.gson.annotations.SerializedName


data class TrainerResponse(
    var id: Int,
    var trainerName: String,
    @SerializedName("trainerSalary")
    var salary: Double,
    var trainerSurnameX: String?
)