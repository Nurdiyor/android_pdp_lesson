package uz.micro.star.lesson_41.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import uz.micro.star.lesson_34.retrofit.models.response.TrainerResponse
import uz.micro.star.lesson_41.retrofit.models.request.LogInRequest
import uz.micro.star.lesson_41.retrofit.models.request.TrainerRequest
import uz.micro.star.lesson_41.retrofit.models.response.LogInResponse

interface ApiService {

    @GET("trainer")
    suspend fun getTrainersList(): Response<List<TrainerResponse>>

}