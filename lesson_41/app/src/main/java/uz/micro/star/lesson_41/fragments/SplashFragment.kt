package uz.micro.star.lesson_41.fragments

import uz.micro.star.lesson_41.R
import uz.micro.star.lesson_41.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override fun onViewCreate() {
        binding.text1.setOnClickListener {
            navController.navigate(R.id.action_splashFragment_to_weatherFragment)
        }
    }
}