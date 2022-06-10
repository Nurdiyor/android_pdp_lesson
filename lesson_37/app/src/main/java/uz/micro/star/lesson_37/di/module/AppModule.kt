package uz.micro.star.lesson_37.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import uz.micro.star.lesson_37.utils.SharedPref
import javax.inject.Singleton

/**
 * Created by Microstar on 02.06.2020.
 */

@Module(
    includes = [
        NetworkModule::class,
    ]
)
object AppModule {

    @Singleton
    @Provides
    fun provideShared(application: Application) = SharedPref(application.applicationContext)

//    @Singleton
//    @Provides
//    fun provideGson() = Gson()
}