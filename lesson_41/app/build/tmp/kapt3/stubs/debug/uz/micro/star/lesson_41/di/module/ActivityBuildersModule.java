package uz.micro.star.lesson_41.di.module;

import java.lang.System;

/**
 * Created by Microstar on 02.06.2020.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\'\u00a8\u0006\u0005"}, d2 = {"Luz/micro/star/lesson_41/di/module/ActivityBuildersModule;", "", "()V", "contributeMainActivity", "Luz/micro/star/lesson_41/MainActivity;", "app_debug"})
@dagger.Module()
public abstract class ActivityBuildersModule {
    
    public ActivityBuildersModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector(modules = {uz.micro.star.lesson_41.di.module.ViewModelsModule.class, uz.micro.star.lesson_41.di.module.MainFragmentBuildersModule.class})
    public abstract uz.micro.star.lesson_41.MainActivity contributeMainActivity();
}