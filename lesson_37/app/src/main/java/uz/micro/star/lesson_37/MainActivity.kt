package uz.micro.star.lesson_37

import android.os.Bundle
import android.util.Log
import dagger.android.support.DaggerAppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.micro.star.lesson_34.retrofit.models.response.TrainerResponse
import uz.micro.star.lesson_37.databinding.ActivityMainBinding
import uz.micro.star.lesson_37.retrofit.ApiService
import uz.micro.star.lesson_37.retrofit.models.request.LogInRequest
import uz.micro.star.lesson_37.retrofit.models.response.LogInResponse
import uz.micro.star.lesson_37.utils.SharedPref
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var sharedPref: SharedPref

    @Inject
    lateinit var apiService: ApiService

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        sharedPref = SharedPref(this)
        Log.d("TTTT", "language: ${sharedPref.getLang()}")
        binding.signIn.setOnClickListener {
            apiService.logIn(LogInRequest("sheralizorro", "123456"))
                .enqueue(object : Callback<LogInResponse> {
                    override fun onResponse(
                        call: Call<LogInResponse>,
                        response: Response<LogInResponse>
                    ) {
                        if (response.code() == 200) {
                            response.body()?.let {
                                sharedPref.setToken(it.accessToken)
                            }
                        }
                    }

                    override fun onFailure(call: Call<LogInResponse>, t: Throwable) {

                    }
                })
        }
        binding.getList.setOnClickListener {
            apiService.getTrainersList().enqueue(object : Callback<List<TrainerResponse>> {
                override fun onResponse(
                    call: Call<List<TrainerResponse>>,
                    response: Response<List<TrainerResponse>>
                ) {

                }

                override fun onFailure(call: Call<List<TrainerResponse>>, t: Throwable) {

                }

            })
        }
    }
}