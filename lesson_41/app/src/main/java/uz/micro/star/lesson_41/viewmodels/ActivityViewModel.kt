package uz.micro.star.lesson_41.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import uz.micro.star.lesson_34.retrofit.models.response.TrainerResponse
import uz.micro.star.lesson_41.repository.ActivityRepository
import uz.micro.star.lesson_41.retrofit.models.BaseNetworkResult
import uz.micro.star.lesson_41.utils.SharedPref
import javax.inject.Inject

class ActivityViewModel @Inject constructor(
    private val activityRepository: ActivityRepository,
    private var sharedPreferencesHelper: SharedPref
) : ViewModel() {
    //    private val trainersList = MutableLiveData<List<TrainerResponse>>()
//    val trainersListLiveData: LiveData<List<TrainerResponse>> get() = trainersList
    private val trainersList = Channel<List<TrainerResponse>>()
    val trainersListChannel = trainersList.receiveAsFlow()
    private val errorMessage = MutableLiveData<String>()
    val errorMessageLiveData: LiveData<String> get() = errorMessage

    fun getAllTrainers() {
        viewModelScope.launch {
            activityRepository.getAllTrainers().catch {
                Log.d("EXC", "getAllTrainers: exception")
            }.collect {
                when (it) {
                    is BaseNetworkResult.Error -> {
                        it.message?.let { error ->
                            errorMessage.value = error
                        }
                    }
                    is BaseNetworkResult.Success -> {
                        it.data?.let { list ->
                            trainersList.send(list)
                        }

                    }
                }
            }
        }
    }

}