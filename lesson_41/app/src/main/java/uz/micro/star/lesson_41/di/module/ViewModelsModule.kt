package uz.micro.star.lesson_41.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.micro.star.lesson_41.di.scopes.ViewModelKey
import uz.micro.star.lesson_41.viewmodels.ActivityViewModel

@Module
abstract class ViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(ActivityViewModel::class)
    abstract fun mainViewModel(activityViewModel: ActivityViewModel): ViewModel

}