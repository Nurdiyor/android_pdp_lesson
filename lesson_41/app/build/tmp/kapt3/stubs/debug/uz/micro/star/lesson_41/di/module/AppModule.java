package uz.micro.star.lesson_41.di.module;

import java.lang.System;

/**
 * Created by Microstar on 02.06.2020.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Luz/micro/star/lesson_41/di/module/AppModule;", "", "()V", "provideShared", "Luz/micro/star/lesson_41/utils/SharedPref;", "application", "Landroid/app/Application;", "app_debug"})
@dagger.Module(includes = {uz.micro.star.lesson_41.di.module.NetworkModule.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final uz.micro.star.lesson_41.di.module.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final uz.micro.star.lesson_41.utils.SharedPref provideShared(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
}