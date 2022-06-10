package uz.micro.star.lesson_41.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.micro.star.lesson_34.retrofit.models.response.TrainerResponse
import uz.micro.star.lesson_41.retrofit.ApiService
import uz.micro.star.lesson_41.retrofit.models.BaseNetworkResult
import uz.micro.star.lesson_41.utils.SharedPref
import javax.inject.Inject

class ActivityRepository @Inject constructor(
    private var service: ApiService,
    private var sharedPreferencesHelper: SharedPref
) {

    fun getAllTrainers(): LiveData<BaseNetworkResult<List<TrainerResponse>>> {
        val data = MutableLiveData<BaseNetworkResult<List<TrainerResponse>>>()
//        GlobalScope.launch(Dispatchers.IO) {
//
//        }
        CoroutineScope(Dispatchers.IO).launch {

            val response = service.getTrainersList()
            if (response.code() == 200) {
                response.body()?.let {
//                    data.value = BaseNetworkResult.Success(it)
//                    data.postValue(BaseNetworkResult.Success(it))
//                    withContext(Dispatchers.Main){
//                        data.value = BaseNetworkResult.Success(it)
//                    }
//                    withContext(Dispatchers.Main) {
//                        data.value = BaseNetworkResult.Success(it)
//                    }
                    launch(Dispatchers.Main) {
                        data.value = BaseNetworkResult.Success(it)
                    }
                }
            } else if (response.code() == 400) {
                data.value = BaseNetworkResult.Error("You have an error")
            } else {
                data.value = BaseNetworkResult.Error("You have an error")
            }
        }
        return data
    }
}