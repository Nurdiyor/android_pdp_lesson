package uz.micro.star.lesson_41.di.module;

import java.lang.System;

/**
 * Created by Microstar on 02.06.2020.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Luz/micro/star/lesson_41/di/module/ViewModelFactoryModule;", "", "()V", "bindViewModelFactor", "Landroidx/lifecycle/ViewModelProvider$Factory;", "modelProviderFactory", "Luz/micro/star/lesson_41/viewmodels/DaggerViewModelFactory;", "app_debug"})
@dagger.Module()
public abstract class ViewModelFactoryModule {
    
    public ViewModelFactoryModule() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @dagger.Binds()
    public abstract androidx.lifecycle.ViewModelProvider.Factory bindViewModelFactor(@org.jetbrains.annotations.Nullable()
    uz.micro.star.lesson_41.viewmodels.DaggerViewModelFactory modelProviderFactory);
}