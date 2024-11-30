package uz.micro.star.lesson_37.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import uz.micro.star.lesson_34.retrofit.models.response.TrainerResponse
import uz.micro.star.lesson_37.retrofit.models.request.LogInRequest
import uz.micro.star.lesson_37.retrofit.models.request.SignUpRequest
import uz.micro.star.lesson_37.retrofit.models.response.LogInResponse

interface ApiService {

    @GET("trainer")
    fun getTrainersList(): Call<List<TrainerResponse>>

    @POST("auth/signup")
    suspend fun signUp(@Body signUpRequest: SignUpRequest): Response<Void>

    @POST("auth/signin")
    suspend fun signIn(@Body logInRequest: LogInRequest): Response<LogInResponse>
}