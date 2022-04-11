package uz.micro.star.lesson_21.retrofit

import retrofit2.Call
import retrofit2.http.GET
import uz.micro.star.lesson_21.models.response.PhotoResponse

interface ApiInterface {

    @GET("/photos")
    fun getPhotoList(): Call<List<PhotoResponse>>

}