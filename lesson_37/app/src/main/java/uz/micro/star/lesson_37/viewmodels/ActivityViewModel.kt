package uz.micro.star.lesson_37.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.micro.star.lesson_37.retrofit.models.BaseNetworkResult
import uz.micro.star.lesson_34.retrofit.models.response.TrainerResponse
import uz.micro.star.lesson_37.repository.ActivityRepository
import uz.micro.star.lesson_37.utils.SharedPref
import javax.inject.Inject

class ActivityViewModel @Inject constructor(
    private val activityRepository: ActivityRepository,
    private var sharedPreferencesHelper: SharedPref
) : ViewModel() {
    private val trainersList = MutableLiveData<List<TrainerResponse>>()
    val trainersListLiveData: LiveData<List<TrainerResponse>> get() = trainersList

    private val errorMessage = MutableLiveData<String>()
    val errorMessageLiveData: LiveData<String> get() = errorMessage

    fun getAllTrainers() {
        activityRepository.getAllTrainers().observeForever {
            when (it) {
                is BaseNetworkResult.Error -> {
                    it.message?.let { error ->
                        errorMessage.value = error
                    }
                }
                is BaseNetworkResult.Success -> {
                    it.data?.let { list ->
                        trainersList.value = list
                    }

                }
            }
        }
    }

}