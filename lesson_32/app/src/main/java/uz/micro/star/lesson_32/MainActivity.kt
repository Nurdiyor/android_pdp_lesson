package uz.micro.star.lesson_32

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import uz.micro.star.lesson_32.adapter.UserAdapter
import uz.micro.star.lesson_32.databinding.ActivityMainBinding
import uz.micro.star.lesson_32.entities.UserEntity
import uz.micro.star.lesson_32.room.AppDatabase

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val adapter by lazy {
        UserAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.list.layoutManager = LinearLayoutManager(this)
        binding.list.adapter = adapter
        adapter.setOnItemClickListener { user, pos ->
            deleteUser(user)
            adapter.deleteUser(user, pos)
        }
        binding.add.setOnClickListener {
            addUser("Sanjar", "+9987654345678")
        }
        getAllUser()
    }

    fun addUser(name: String, number: String) {
        AppDatabase.database?.getInputData()?.saveUser(UserEntity(name = name, number = number))
        getAllUser()
    }

    fun deleteUser(user: UserEntity) {
        AppDatabase.database?.getInputData()?.deleteUser(user)
        getAllUser()
    }

    private fun getAllUser() {
        val allUsers = AppDatabase.database?.getInputData()?.getAllUsers()
        allUsers?.let {
            adapter.setAllUser(it)
        }

    }
}