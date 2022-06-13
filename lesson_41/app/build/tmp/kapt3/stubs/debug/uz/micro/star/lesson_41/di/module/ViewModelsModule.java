package uz.micro.star.lesson_41.di.module;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Luz/micro/star/lesson_41/di/module/ViewModelsModule;", "", "()V", "mainViewModel", "Landroidx/lifecycle/ViewModel;", "activityViewModel", "Luz/micro/star/lesson_41/viewmodels/ActivityViewModel;", "app_debug"})
@dagger.Module()
public abstract class ViewModelsModule {
    
    public ViewModelsModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @uz.micro.star.lesson_41.di.scopes.ViewModelKey(value = uz.micro.star.lesson_41.viewmodels.ActivityViewModel.class)
    @dagger.multibindings.IntoMap()
    @dagger.Binds()
    public abstract androidx.lifecycle.ViewModel mainViewModel(@org.jetbrains.annotations.NotNull()
    uz.micro.star.lesson_41.viewmodels.ActivityViewModel activityViewModel);
}