package uz.micro.star.lesson_37.fragments

import android.util.Log
import android.widget.Toast
import uz.micro.star.lesson_37.databinding.FragmentWeatherBinding

class WeatherFragment : BaseFragment<FragmentWeatherBinding>(
    FragmentWeatherBinding::inflate
) {
    override fun onViewCreate() {

        viewModel.errorMessageLiveData.observe(viewLifecycleOwner){
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
        viewModel.trainersListLiveData.observe(viewLifecycleOwner){
            //
            it.forEach {
                Log.d("HHH","--------------${it.trainerName}----------------")
            }
        }
        viewModel.getAllTrainers()
    }
}