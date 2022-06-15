package uz.micro.star.lesson_37.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import uz.micro.star.lesson_37.repository.ActivityRepository
import uz.micro.star.lesson_37.retrofit.models.BaseNetworkResult
import uz.micro.star.lesson_37.utils.SharedPref
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val activityRepository: ActivityRepository
) : ViewModel() {
    private val logUpChannel = Channel<Boolean>()
    val logUpFlow = logUpChannel.receiveAsFlow()

    fun signUp(
        name: String,
        userName: String,
        email: String,
        password: String,
        confirmPassword: String,
    ) {
        viewModelScope.launch {
            activityRepository.signUp(name, userName, email, password, confirmPassword).catch {
                //xatolik beriladi
                Log.d("DDDD", "getServicesResponse: blaaaaaaaaaaa $this")
            }.collect { result ->
                when (result) {
                    is BaseNetworkResult.Success -> {
                        result.data?.let { isSignUp ->
                            logUpChannel.send(isSignUp)
                        }
                    }
                    is BaseNetworkResult.Error -> {
                        //network error
                        Log.d("DDDD", "getServicesResponse: xatooooooo")
                    }
                    is BaseNetworkResult.Loading -> {
                        //loading
//                       result.isLoading?.let {
//                           _isLoadingLiveData.value = it
//                       }
                    }
                }
            }
        }
    }
}