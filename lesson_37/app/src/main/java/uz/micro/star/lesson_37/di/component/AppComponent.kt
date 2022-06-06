package uz.micro.star.lesson_37.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import uz.micro.star.lesson_37.app.App
import uz.micro.star.lesson_37.di.module.ActivityBuildersModule
import uz.micro.star.lesson_37.di.module.AppModule
import uz.micro.star.lesson_37.di.module.ViewModelFactoryModule
import javax.inject.Singleton

/**
 * Created by Microstar on 02.06.2020.
 */
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuildersModule::class,
        ViewModelFactoryModule::class,
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}
