package uz.micro.star.lesson_27

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.micro.star.lesson_27.controller.FragmentController
import uz.micro.star.lesson_27.fragments.FirstFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FragmentController.init(R.id.container, supportFragmentManager)
        FragmentController.controller?.startMainFragment(FirstFragment())
    }
}