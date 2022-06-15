package uz.micro.star.lesson_37.di.module

//import android.window.SplashScreen
import dagger.Module
import dagger.android.ContributesAndroidInjector
import uz.micro.star.lesson_37.fragments.*

/**
 * Created by Microstar on 02.06.2020.
 */
@Module
abstract class MainFragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun splashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun weatherFragment(): WeatherFragment

    @ContributesAndroidInjector
    abstract fun signUpFragment(): SignUpFragment

    @ContributesAndroidInjector
    abstract fun logInFragment(): LogInFragment

    @ContributesAndroidInjector
    abstract fun trainerFragment(): TrainerFragment

}