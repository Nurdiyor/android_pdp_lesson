package uz.micro.star.lesson_41.di.module;

import java.lang.System;

/**
 * Created by Microstar on 02.06.2020.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\'J\b\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Luz/micro/star/lesson_41/di/module/MainFragmentBuildersModule;", "", "()V", "splashFragment", "Luz/micro/star/lesson_41/fragments/SplashFragment;", "weatherFragment", "Luz/micro/star/lesson_41/fragments/WeatherFragment;", "app_debug"})
@dagger.Module()
public abstract class MainFragmentBuildersModule {
    
    public MainFragmentBuildersModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract uz.micro.star.lesson_41.fragments.SplashFragment splashFragment();
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    public abstract uz.micro.star.lesson_41.fragments.WeatherFragment weatherFragment();
}