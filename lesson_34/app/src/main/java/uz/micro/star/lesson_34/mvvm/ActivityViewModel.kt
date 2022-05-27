package uz.micro.star.lesson_34.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.micro.star.lesson_34.dto.TrainerDto
import uz.micro.star.lesson_34.repository.ActivityRepository
import uz.micro.star.lesson_34.retrofit.models.BaseNetworkResult

class ActivityViewModel : ViewModel() {
    val repository = ActivityRepository()
    private val _trainerListViewModel = MutableLiveData<List<TrainerDto>>()
    val trainerListViewModel: LiveData<List<TrainerDto>> get() = _trainerListViewModel

    private val _loadingViewModel = MutableLiveData<Boolean>()
    val loadingViewModel: LiveData<Boolean> get() = _loadingViewModel

    private val _errorViewModel = MutableLiveData<String>()
    val errorViewModel: LiveData<String> get() = _errorViewModel

    fun getAllTrainer() {
        repository.getAllTrainer().observeForever {
            when (it) {
                is BaseNetworkResult.Success -> {
                    _trainerListViewModel.value = it.data?.sortedBy { trainer ->
                        trainer.trainerName
                    }
                }
                is BaseNetworkResult.Error -> {
                    _errorViewModel.value = it.message
                }
                is BaseNetworkResult.Loading -> {
                    _loadingViewModel.value = it.isLoading
                }
            }

        }
    }
}