package uz.micro.star.lesson_37.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import uz.micro.star.lesson_37.MainActivity

/**
 * Created by Microstar on 02.06.2020.
 */

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(modules = [ViewModelsModule::class, MainFragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity

//    @ContributesAndroidInjector(modules = [MainFragmentBuildersModule::class, ViewModelsModule::class])
//    abstract fun contributeHumoPayActivity(): HumoPayActivity
//
//    @ContributesAndroidInjector(modules = [LoginFragmentsBuildersModule::class, ViewModelsModule::class])
//    abstract fun contributeLoginActivity(): LoginActivity


}