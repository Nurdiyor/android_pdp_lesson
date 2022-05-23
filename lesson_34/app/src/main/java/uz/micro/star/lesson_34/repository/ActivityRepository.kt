package uz.micro.star.lesson_34.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.micro.star.lesson_34.retrofit.ApiCLient
import uz.micro.star.lesson_34.retrofit.ApiInterface
import uz.micro.star.lesson_34.retrofit.models.BaseNetworkResult
import uz.micro.star.lesson_34.retrofit.models.response.TrainerResponse

class ActivityRepository {
    //retrofit
    private var apiInterface: ApiInterface? = ApiCLient.retrofit!!.create(ApiInterface::class.java)
    //room db
//        private var database=AppDatabase.database?.getInputData()?


    fun getAllTrainer(): LiveData<BaseNetworkResult<List<TrainerResponse>>> {
        val listViewModel = MutableLiveData<BaseNetworkResult<List<TrainerResponse>>>()
//        listViewModel.value = database.getAllUSers()
        listViewModel.value = BaseNetworkResult.Loading(true)
        apiInterface?.getTrainersList()?.enqueue(object : Callback<List<TrainerResponse>> {
            override fun onResponse(
                call: Call<List<TrainerResponse>>,
                response: Response<List<TrainerResponse>>
            ) {
                listViewModel.value = BaseNetworkResult.Loading(false)
                if (response.code() == 200) {
                    response.body()?.let {
                        listViewModel.value = BaseNetworkResult.Success(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<TrainerResponse>>, t: Throwable) {
                listViewModel.value = BaseNetworkResult.Loading(false)
                listViewModel.value = BaseNetworkResult.Error("No internet connection")
            }

        })

        return listViewModel
    }
}