package uz.micro.star.lesson_41.retrofit.models.response


import com.google.gson.annotations.SerializedName

data class LogInResponse(
    @SerializedName("accessToken")
    var accessToken: String,
    @SerializedName("tokenType")
    var tokenType: String
)