package uz.micro.star.lesson_34

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import uz.micro.star.lesson_34.adapter.TrainerAdapter
import uz.micro.star.lesson_34.databinding.ActivityMainBinding
import uz.micro.star.lesson_34.mvvm.ActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewmodel: ActivityViewModel
    lateinit var binding: ActivityMainBinding
    val adapter by lazy {
        TrainerAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            list.layoutManager = LinearLayoutManager(this@MainActivity)
            list.adapter = adapter
        }
        viewmodel = ViewModelProvider(this)[ActivityViewModel::class.java]

        viewmodel.trainerListViewModel.observe(this) {
            adapter.setNewData(it)
        }
        viewmodel.loadingViewModel.observe(this) {
            binding.swipeRefresh.isRefreshing = it
        }
        viewmodel.errorViewModel.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        binding.swipeRefresh.setOnRefreshListener {
            viewmodel.getAllTrainer()
        }
        viewmodel.getAllTrainer()
    }

}