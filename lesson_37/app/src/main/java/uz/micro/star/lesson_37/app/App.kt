package uz.micro.star.lesson_37.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import uz.micro.star.lesson_37.di.component.DaggerAppComponent

class App: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}