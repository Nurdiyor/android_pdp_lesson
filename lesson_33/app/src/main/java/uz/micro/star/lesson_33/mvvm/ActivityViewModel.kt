package uz.micro.star.lesson_33.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityViewModel : ViewModel() {
    val myText = MutableLiveData<String>()
    private val _plusViewModel = MutableLiveData<Int>()
    val plusViewModel: LiveData<Int> get() = _plusViewModel

    private val _listViewModel = MutableLiveData<List<String>>()
    val listViewModel: LiveData<List<String>> get() = _listViewModel

    fun plus(a: Int, b: Int) {
        val c = a + b
        _plusViewModel.value = c
    }

    fun addData() {
        val data = ArrayList<String>()
        data.add("wqer")
        data.add("wqer")
        data.add("wqer")
        data.add("wqer")
        data.add("wqer")
        data.add("wqer")
        _listViewModel.value = data
    }
}