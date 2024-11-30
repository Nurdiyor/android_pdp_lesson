package uz.micro.star.lesson_37.fragments

import uz.micro.star.lesson_37.R
import uz.micro.star.lesson_37.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override fun onViewCreate() {
        binding.text1.setOnClickListener {
            navController.navigate(R.id.action_splashFragment_to_logInFragment)
        }
    }
}