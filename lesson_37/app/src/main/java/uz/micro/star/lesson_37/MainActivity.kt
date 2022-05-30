package uz.micro.star.lesson_37

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import dagger.android.support.DaggerAppCompatActivity
import uz.micro.star.lesson_37.retrofit.ApiService
import uz.micro.star.lesson_37.utils.SharedPref
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var sharedPref: SharedPref

    @Inject
    lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        sharedPref = SharedPref(this)
        Toast.makeText(this, sharedPref.getLang(), Toast.LENGTH_SHORT).show()
        Log.d("TTTT", "language: ${sharedPref.getLang()}")
//        apiService.getTrainersList().enqueue()
        //hello
    }
}