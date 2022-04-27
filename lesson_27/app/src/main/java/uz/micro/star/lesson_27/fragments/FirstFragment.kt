package uz.micro.star.lesson_27.fragments

import android.view.animation.Animation
import uz.micro.star.lesson_27.controller.FragmentController
import uz.micro.star.lesson_27.databinding.FragmentFirstBinding

class FirstFragment : BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {
    override fun onViewCreated() {
        binding.btn.setOnClickListener {
            replaceFragment(SecondFragment())
        }
    }

}