package uz.micro.star.lesson_34.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.micro.star.lesson_34.repository.ActivityRepository

class ActivityViewModel : ViewModel() {
    val repository = ActivityRepository()
    val myText = MutableLiveData<String>()
    val _listViewModel = MutableLiveData<List<UsersResponse>>()
    val listViewModel: LiveData<List<UsersResponse>> get() = _listViewModel

    fun getAllUsers() {
        var amount=0
        repository.getAllUsers().observeForever {
            it.forEach {
//                hwbqwerv
                //awkfbjjkrbnrtbrte
                //dwvkjerb vjerg
            }
            _listViewModel.value = it
        }
    }


}