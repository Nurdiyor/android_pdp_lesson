package uz.micro.star.lesson_37.di.module

import android.app.Application
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.micro.star.lesson_37.retrofit.ApiService
import uz.micro.star.lesson_37.utils.SharedPref
import javax.inject.Singleton

/**
 * Created by Microstar on 02.06.2020.
 */

@Module()
object AppModule {


    @Singleton
    @Provides
    fun provideShared(application: Application) = SharedPref(application.applicationContext)

    @Singleton
    @Provides
    fun provideRetrofitInstance(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl("BASE_URL").client(client)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().serializeNulls().setLenient().create()
                )
            ).build()
    }

    @Singleton
    @Provides
    fun provideLogin(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

//    @Singleton
//    @Provides
//    fun provideGson() = Gson()
}