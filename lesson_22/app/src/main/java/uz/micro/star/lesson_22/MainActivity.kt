package uz.micro.star.lesson_22

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.micro.star.lesson_22.adapter.TrainerAdapter
import uz.micro.star.lesson_22.databinding.ActivityMainBinding
import uz.micro.star.lesson_22.models.request.TrainerRequest
import uz.micro.star.lesson_22.models.response.TrainerResponse
import uz.micro.star.lesson_22.retrofit.ApiCLient
import uz.micro.star.lesson_22.retrofit.ApiInterface

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val adapter by lazy {
        TrainerAdapter()
    }
    private var apiInterface: ApiInterface? = ApiCLient.retrofit!!.create(ApiInterface::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            list.layoutManager = LinearLayoutManager(this@MainActivity)
            list.adapter = adapter
        }
        getTrainersList()
        adapter.setDeleteClickListener { trainer, position ->
            deletTrainer(trainer, position)
        }
        adapter.setEditClickListener { trainer, position ->
            editTrainer(
                TrainerRequest(
                    "QWERTYU",
                    999.999,
                    trainer.trainerSurname
                ), trainer.id, position
            )
        }
        binding.addTrainer.setOnClickListener {
            addTrainer(TrainerRequest("Salimboy", 45.700, "Salim"))
        }
        binding.swipe.setOnRefreshListener {
            getTrainersList()
        }
    }

    private fun editTrainer(trainer: TrainerRequest, id: Int, position: Int) {
        apiInterface?.editTrainer(trainer, id)?.enqueue(object : Callback<TrainerResponse> {
            override fun onResponse(
                call: Call<TrainerResponse>,
                response: Response<TrainerResponse>
            ) {
                if (response.code() == 200) {
                    response.body()?.let {
                        adapter.editTrainer(it, position)
                    }
                }
            }

            override fun onFailure(call: Call<TrainerResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "No connection", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun deletTrainer(trainer: TrainerResponse, position: Int) {
        apiInterface?.deleteTrainer(trainer.id)?.enqueue(object : Callback<TrainerResponse> {
            override fun onResponse(
                call: Call<TrainerResponse>,
                response: Response<TrainerResponse>
            ) {
                if (response.code() == 200) {
                    response.body()?.let {
                        adapter.deleteTrainer(position)
                    }
                }
            }

            override fun onFailure(call: Call<TrainerResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "No connection", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun addTrainer(trainerRequest: TrainerRequest) {
        apiInterface?.addTrainer(trainerRequest)?.enqueue(object : Callback<TrainerResponse> {
            override fun onResponse(
                call: Call<TrainerResponse>,
                response: Response<TrainerResponse>
            ) {
                if (response.code() == 200) {
                    response.body()?.let {
                        adapter.addTrainer(it)
                    }
                }
            }

            override fun onFailure(call: Call<TrainerResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "No connection", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun getTrainersList() {
        apiInterface?.getTrainersList()?.enqueue(object : Callback<List<TrainerResponse>> {
            override fun onResponse(
                call: Call<List<TrainerResponse>>,
                response: Response<List<TrainerResponse>>
            ) {
                binding.swipe.isRefreshing = false
                if (response.code() == 200) {
                    response.body()?.let {
                        adapter.setNewData(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<TrainerResponse>>, t: Throwable) {
                binding.swipe.isRefreshing = false
                Toast.makeText(this@MainActivity, "No connection", Toast.LENGTH_SHORT).show()
            }

        })
    }

}