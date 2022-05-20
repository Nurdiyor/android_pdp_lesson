package uz.micro.star.lesson_34.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ActivityRepository {
    //retrofit
//    private var apiInterface: ApiInterface? = ApiCLient.retrofit!!.create(ApiInterface::class.java)
    //room db
//        private var database=AppDatabase.database?.getInputData()?


    fun getAllUsers(): LiveData<List<UsersResponse>> {
        val listViewModel = MutableLiveData<List<UsersResponse>>()
        listViewModel.value = database.getAllUSers()
        apiInterface.getAllUsers().enqueue(
            {
                //response
                if (response.code == 200) {
                    listViewModel.value = response.body()
                    database.saveAllUsers(respinse.body())
                } else {
                    listViewModel.value = database.getAllUSers()
                }
            },
            {
                //error
            }
        )
        return listViewModel
    }
}