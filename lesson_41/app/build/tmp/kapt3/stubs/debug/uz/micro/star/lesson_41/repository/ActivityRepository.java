package uz.micro.star.lesson_41.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Luz/micro/star/lesson_41/repository/ActivityRepository;", "", "service", "Luz/micro/star/lesson_41/retrofit/ApiService;", "sharedPreferencesHelper", "Luz/micro/star/lesson_41/utils/SharedPref;", "(Luz/micro/star/lesson_41/retrofit/ApiService;Luz/micro/star/lesson_41/utils/SharedPref;)V", "getAllTrainers", "Landroidx/lifecycle/LiveData;", "Luz/micro/star/lesson_41/retrofit/models/BaseNetworkResult;", "", "Luz/micro/star/lesson_34/retrofit/models/response/TrainerResponse;", "app_debug"})
public final class ActivityRepository {
    private uz.micro.star.lesson_41.retrofit.ApiService service;
    private uz.micro.star.lesson_41.utils.SharedPref sharedPreferencesHelper;
    
    @javax.inject.Inject()
    public ActivityRepository(@org.jetbrains.annotations.NotNull()
    uz.micro.star.lesson_41.retrofit.ApiService service, @org.jetbrains.annotations.NotNull()
    uz.micro.star.lesson_41.utils.SharedPref sharedPreferencesHelper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<uz.micro.star.lesson_41.retrofit.models.BaseNetworkResult<java.util.List<uz.micro.star.lesson_34.retrofit.models.response.TrainerResponse>>> getAllTrainers() {
        return null;
    }
}