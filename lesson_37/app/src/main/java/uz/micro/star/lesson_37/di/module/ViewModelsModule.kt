package uz.micro.star.lesson_37.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.micro.star.lesson_37.di.scopes.ViewModelKey
import uz.micro.star.lesson_37.viewmodels.ActivityViewModel
import uz.micro.star.lesson_37.viewmodels.LogInViewModel
import uz.micro.star.lesson_37.viewmodels.SignUpViewModel
import uz.micro.star.lesson_37.viewmodels.TrainerViewModel

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ActivityViewModel::class)
    abstract fun activityViewModel(activityViewModel: ActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    abstract fun signUpViewModel(signUpViewModel: SignUpViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LogInViewModel::class)
    abstract fun logInViewModel(logInViewModel: LogInViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TrainerViewModel::class)
    abstract fun trainerViewModel(trainerViewModel: TrainerViewModel): ViewModel

}