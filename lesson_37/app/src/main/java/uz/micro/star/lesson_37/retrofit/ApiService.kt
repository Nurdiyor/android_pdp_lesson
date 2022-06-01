package uz.micro.star.lesson_37.retrofit

import retrofit2.Call
import retrofit2.http.*
import uz.micro.star.lesson_34.retrofit.models.response.TrainerResponse
import uz.micro.star.lesson_37.retrofit.models.request.LogInRequest
import uz.micro.star.lesson_37.retrofit.models.request.TrainerRequest
import uz.micro.star.lesson_37.retrofit.models.response.LogInResponse

interface ApiService {

    @GET("trainer_with_role")
    fun getTrainersList(): Call<List<TrainerResponse>>

    @POST("trainer_with_role")
    fun addTrainer(@Body trainer: TrainerRequest): Call<TrainerResponse>

    @DELETE("trainer_with_role/{id}")
    fun deleteTrainer(@Path("id") id: Int): Call<TrainerResponse>

    @PUT("trainer_with_role/{id}")
    fun editTrainer(@Body trainer: TrainerRequest, @Path("id") id: Int): Call<TrainerResponse>

    @POST("auth/signin")
    fun logIn(@Body login: LogInRequest): Call<LogInResponse>
}