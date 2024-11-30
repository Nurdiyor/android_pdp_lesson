package uz.micro.star.lesson_41.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.micro.star.lesson_34.retrofit.models.response.TrainerResponse
import uz.micro.star.lesson_41.retrofit.ApiService
import uz.micro.star.lesson_41.retrofit.models.BaseNetworkResult
import uz.micro.star.lesson_41.utils.SharedPref
import javax.inject.Inject

class ActivityRepository @Inject constructor(
    private var service: ApiService,
    private var sharedPreferencesHelper: SharedPref
) {

    fun getAllTrainers(): Flow<BaseNetworkResult<List<TrainerResponse>>> {
        return flow {
            val response = service.getTrainersList()
            when {
                response.code() == 200 -> {
                    response.body()?.let {
                            emit(BaseNetworkResult.Success(it))
                    }
                }
                response.code() == 400 -> {
                    emit(BaseNetworkResult.Error("You have an error"))
                }
                else -> {
                    emit(BaseNetworkResult.Error("You have an error"))
                }
            }
        }
    }
}