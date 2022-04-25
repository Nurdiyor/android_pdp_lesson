package uz.micro.star.lesson_26

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import uz.micro.star.lesson_26.databinding.ActivityMainBinding
import uz.micro.star.lesson_26.ui.FirstFragment
import uz.micro.star.lesson_26.utils.startFragment
import uz.micro.star.lesson_26.utils.startMainFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startMainFragment(FirstFragment())
    }
}