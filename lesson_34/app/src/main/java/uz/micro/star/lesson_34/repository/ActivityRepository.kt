package uz.micro.star.lesson_34.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.micro.star.lesson_34.dto.TrainerDto
import uz.micro.star.lesson_34.retrofit.ApiCLient
import uz.micro.star.lesson_34.retrofit.ApiInterface
import uz.micro.star.lesson_34.retrofit.models.BaseNetworkResult
import uz.micro.star.lesson_34.retrofit.models.response.TrainerResponse
import uz.micro.star.lesson_34.room.AppDatabase
import uz.micro.star.lesson_34.room.entities.TrainerEntity

class ActivityRepository {
    //retrofit
    private var apiInterface: ApiInterface? = ApiCLient.retrofit!!.create(ApiInterface::class.java)

    //room db
    private var database = AppDatabase.database?.getInputData()


    fun getAllTrainer(): LiveData<BaseNetworkResult<List<TrainerDto>>> {
        val listLiveData = MutableLiveData<BaseNetworkResult<List<TrainerDto>>>()

        listLiveData.value = BaseNetworkResult.Loading(true)
        database?.getAllTrainers()?.let { list ->
            listLiveData.value = BaseNetworkResult.Success(
                list.map {
                    TrainerDto(it.id, it.trainerName, it.salary, it.trainerSurname)
                }
            )
        }
        apiInterface?.getTrainersList()?.enqueue(object : Callback<List<TrainerResponse>> {
            override fun onResponse(
                call: Call<List<TrainerResponse>>,
                response: Response<List<TrainerResponse>>
            ) {
                listLiveData.value = BaseNetworkResult.Loading(false)
                if (response.code() == 200) {
                    response.body()?.let {
//                        val d = ArrayList<TrainerDto>()
//                        it.forEach { trainer ->
//                            d.add(
//                                TrainerDto(
//                                    trainer.id,
//                                    trainer.trainerName,
//                                    trainer.trainerSalary,
//                                    trainer.trainerSurname
//                                )
//                            )
//                        }

                        listLiveData.value = BaseNetworkResult.Success(it.map { trainer ->
                            TrainerDto(
                                trainer.id,
                                trainer.trainerName,
                                trainer.salary,
                                trainer.trainerSurnameX?:""
                            )
                        })
                        database?.deleteAll()
                        database?.saveTrainers(it.map { trainer ->
                            TrainerEntity(
                                trainer.id,
                                trainer.trainerName,
                                trainer.salary,
                                trainer.trainerSurnameX?:""
                            )
                        })
                    }
                }
            }

            override fun onFailure(call: Call<List<TrainerResponse>>, t: Throwable) {
                listLiveData.value = BaseNetworkResult.Loading(false)
                listLiveData.value = BaseNetworkResult.Error("No internet connection")
            }

        })

        return listLiveData
    }
}