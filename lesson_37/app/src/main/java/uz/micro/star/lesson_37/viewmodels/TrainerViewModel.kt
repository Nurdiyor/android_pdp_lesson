package uz.micro.star.lesson_37.viewmodels

import androidx.lifecycle.ViewModel
import uz.micro.star.lesson_37.repository.ActivityRepository
import uz.micro.star.lesson_37.utils.SharedPref
import javax.inject.Inject

class TrainerViewModel @Inject constructor(
    private val activityRepository: ActivityRepository,
    private var sharedPreferencesHelper: SharedPref
) : ViewModel() {

}