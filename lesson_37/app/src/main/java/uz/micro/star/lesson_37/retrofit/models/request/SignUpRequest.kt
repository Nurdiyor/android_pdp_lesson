package uz.micro.star.lesson_37.retrofit.models.request


import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("email")
    var email: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("password")
    var password: String,
    @SerializedName("role")
    var role: List<String> = listOf("ROLE_USER"),
    @SerializedName("username")
    var username: String
)