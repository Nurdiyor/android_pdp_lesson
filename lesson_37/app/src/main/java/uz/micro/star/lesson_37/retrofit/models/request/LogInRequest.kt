package uz.micro.star.lesson_37.retrofit.models.request


import com.google.gson.annotations.SerializedName

data class LogInRequest(
    @SerializedName("username")
    var username: String,
    @SerializedName("password")
    var password: String
)