package uz.micro.star.lesson_41.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\r\u00a8\u0006\u0015"}, d2 = {"Luz/micro/star/lesson_41/viewmodels/ActivityViewModel;", "Landroidx/lifecycle/ViewModel;", "activityRepository", "Luz/micro/star/lesson_41/repository/ActivityRepository;", "sharedPreferencesHelper", "Luz/micro/star/lesson_41/utils/SharedPref;", "(Luz/micro/star/lesson_41/repository/ActivityRepository;Luz/micro/star/lesson_41/utils/SharedPref;)V", "errorMessage", "Landroidx/lifecycle/MutableLiveData;", "", "errorMessageLiveData", "Landroidx/lifecycle/LiveData;", "getErrorMessageLiveData", "()Landroidx/lifecycle/LiveData;", "trainersList", "", "Luz/micro/star/lesson_34/retrofit/models/response/TrainerResponse;", "trainersListLiveData", "getTrainersListLiveData", "getAllTrainers", "", "app_debug"})
public final class ActivityViewModel extends androidx.lifecycle.ViewModel {
    private final uz.micro.star.lesson_41.repository.ActivityRepository activityRepository = null;
    private uz.micro.star.lesson_41.utils.SharedPref sharedPreferencesHelper;
    private final androidx.lifecycle.MutableLiveData<java.util.List<uz.micro.star.lesson_34.retrofit.models.response.TrainerResponse>> trainersList = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> errorMessage = null;
    
    @javax.inject.Inject()
    public ActivityViewModel(@org.jetbrains.annotations.NotNull()
    uz.micro.star.lesson_41.repository.ActivityRepository activityRepository, @org.jetbrains.annotations.NotNull()
    uz.micro.star.lesson_41.utils.SharedPref sharedPreferencesHelper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<uz.micro.star.lesson_34.retrofit.models.response.TrainerResponse>> getTrainersListLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorMessageLiveData() {
        return null;
    }
    
    public final void getAllTrainers() {
    }
}