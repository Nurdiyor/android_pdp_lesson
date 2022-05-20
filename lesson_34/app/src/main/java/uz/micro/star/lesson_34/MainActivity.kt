package uz.micro.star.lesson_34

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import uz.micro.star.lesson_34.mvvm.ActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewmodel: ActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewmodel = ViewModelProvider(this)[ActivityViewModel::class.java]

        viewmodel.listViewModel.observe(this){
            adapter.setUserList(it)
        }
        viewmodel.getAllUsers()
    }

}