package uz.micro.star.lesson_41.di.component;

import java.lang.System;

/**
 * Created by Microstar on 02.06.2020.
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Luz/micro/star/lesson_41/di/component/AppComponent;", "Ldagger/android/AndroidInjector;", "Luz/micro/star/lesson_41/app/App;", "Builder", "app_debug"})
@dagger.Component(modules = {dagger.android.support.AndroidSupportInjectionModule.class, uz.micro.star.lesson_41.di.module.AppModule.class, uz.micro.star.lesson_41.di.module.ActivityBuildersModule.class, uz.micro.star.lesson_41.di.module.ViewModelFactoryModule.class})
@javax.inject.Singleton()
public abstract interface AppComponent extends dagger.android.AndroidInjector<uz.micro.star.lesson_41.app.App> {
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\'J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Luz/micro/star/lesson_41/di/component/AppComponent$Builder;", "", "application", "Landroid/app/Application;", "build", "Luz/micro/star/lesson_41/di/component/AppComponent;", "app_debug"})
    @dagger.Component.Builder()
    public static abstract interface Builder {
        
        @org.jetbrains.annotations.NotNull()
        @dagger.BindsInstance()
        public abstract uz.micro.star.lesson_41.di.component.AppComponent.Builder application(@org.jetbrains.annotations.NotNull()
        android.app.Application application);
        
        @org.jetbrains.annotations.NotNull()
        public abstract uz.micro.star.lesson_41.di.component.AppComponent build();
    }
}