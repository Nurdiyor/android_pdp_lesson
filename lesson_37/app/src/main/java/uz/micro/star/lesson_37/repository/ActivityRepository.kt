package uz.micro.star.lesson_37.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.micro.star.lesson_34.retrofit.models.response.TrainerResponse
import uz.micro.star.lesson_37.retrofit.ApiService
import uz.micro.star.lesson_37.retrofit.models.BaseNetworkResult
import uz.micro.star.lesson_37.utils.SharedPref
import javax.inject.Inject

class ActivityRepository @Inject constructor(
    private var service: ApiService,
    private var sharedPreferencesHelper: SharedPref
) {

    fun getAllTrainers(): LiveData<BaseNetworkResult<List<TrainerResponse>>> {
        val data = MutableLiveData<BaseNetworkResult<List<TrainerResponse>>>()
        service.getTrainersList().enqueue(object : Callback<List<TrainerResponse>> {
            override fun onResponse(
                call: Call<List<TrainerResponse>>,
                response: Response<List<TrainerResponse>>
            ) {
                if (response.code() == 200) {
                    response.body()?.let {
                        data.value = BaseNetworkResult.Success(it)
                    }
                } else if (response.code() == 400) {
                    data.value = BaseNetworkResult.Error("You have an error")
                } else {
                    data.value = BaseNetworkResult.Error("You have an error")
                }
            }

            override fun onFailure(call: Call<List<TrainerResponse>>, t: Throwable) {
                data.value = BaseNetworkResult.Error("No internet connection")
            }

        })
        return data
    }
}