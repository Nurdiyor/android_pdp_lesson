package uz.micro.star.lesson_37.di.module

import android.app.Application
import androidx.viewbinding.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
    fun provideRetrofit(httpLoggingInterceptor: HttpLoggingInterceptor): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl("BASE_URL")
            client(OkHttpClient.Builder().addNetworkInterceptor(httpLoggingInterceptor).build())
//                .addCallAdapterFactory(CoroutineCallAdapterFactory())
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }

    @Singleton
    @Provides
    fun provideLogin(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return httpLoggingInterceptor
    }

//    @Singleton
//    @Provides
//    fun provideGson() = Gson()
}