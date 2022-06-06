package uz.micro.star.lesson_37.di.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.micro.star.lesson_37.retrofit.ApiService
import uz.micro.star.lesson_37.utils.SharedPref
import javax.inject.Singleton

@Module
object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(httpLoggingInterceptor: HttpLoggingInterceptor, shared: SharedPref): Retrofit {
//        val httpLoggingInterceptor = HttpLoggingInterceptor()
//        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return Retrofit.Builder()
            .baseUrl("https://microstar.herokuapp.com/api/")
            .client(
                OkHttpClient.Builder().addNetworkInterceptor(httpLoggingInterceptor)
                .addInterceptor { chain ->
                    val request = chain.request()
                    val newRequest = if (shared.getToken().isNullOrEmpty())
                        request.newBuilder()
                    else request.newBuilder()
                        .header("Authorization", "Bearer ${shared.getToken()}")
                    chain.proceed(newRequest.build()).also {
//                        if (it.code == 401) {
////                            Handler(Looper.getMainLooper()).post { shared.setAccessToken("empty") }
//                        }
                    }
                }
                .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Singleton
    @Provides
    fun provideLogin(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
//        val httpLoggingInterceptor = HttpLoggingInterceptor()
//        if (BuildConfig.DEBUG) {
//            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        } else {
//            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
//        }
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }
}