package uz.micro.star.lesson_41.fragments

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenCreated
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.micro.star.lesson_41.databinding.FragmentWeatherBinding

class WeatherFragment : BaseFragment<FragmentWeatherBinding>(
    FragmentWeatherBinding::inflate
) {
    override fun onViewCreate() {

        viewModel.errorMessageLiveData.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
//        viewModel.trainersListLiveData.observe(viewLifecycleOwner){
//            //
//            it.forEach {
//                Log.d("HHH","--------------${it.trainerName}----------------")
//            }
//        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.whenCreated {
                viewModel.trainersListChannel.collect {
                    it.forEach {
                        Log.d("HHH", "--------------${it.trainerName}----------------")
                    }
                }
            }
        }
        viewModel.getAllTrainers()
    }
}