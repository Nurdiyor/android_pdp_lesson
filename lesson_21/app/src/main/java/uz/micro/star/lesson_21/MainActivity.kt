package uz.micro.star.lesson_21

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.micro.star.lesson_21.adapter.PhotoAdapter
import uz.micro.star.lesson_21.databinding.ActivityMainBinding
import uz.micro.star.lesson_21.models.response.PhotoResponse
import uz.micro.star.lesson_21.retrofit.ApiCLient
import uz.micro.star.lesson_21.retrofit.ApiInterface

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val adapter by lazy {
        PhotoAdapter()
    }
    private var apiInterface: ApiInterface? = ApiCLient.retrofit!!.create(ApiInterface::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            photosList.layoutManager = LinearLayoutManager(this@MainActivity)
            photosList.adapter = adapter
        }
        apiInterface?.getPhotoList()?.enqueue(object : Callback<List<PhotoResponse>> {
            override fun onResponse(
                call: Call<List<PhotoResponse>>,
                response: Response<List<PhotoResponse>>
            ) {
                if (response.code() == 200) {
                    response.body()?.forEach {
                        Log.d("PPPP", "onResponse: ${it.title}")
                    }
                    response.body()?.let {
                        adapter.setNewData(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<PhotoResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "No internet connection", Toast.LENGTH_LONG)
                    .show()
                Log.d("PPPP", "onFailure: $t")
            }

        })
    }
}