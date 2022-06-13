package uz.micro.star.lesson_41.retrofit.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\u0010\u0011\u0012B+\b\u0004\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bR\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0006\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u0082\u0001\u0003\u0013\u0014\u0015\u00a8\u0006\u0016"}, d2 = {"Luz/micro/star/lesson_41/retrofit/models/BaseNetworkResult;", "T", "", "data", "message", "", "isLoading", "", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Boolean;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMessage", "()Ljava/lang/String;", "Error", "Loading", "Success", "Luz/micro/star/lesson_41/retrofit/models/BaseNetworkResult$Success;", "Luz/micro/star/lesson_41/retrofit/models/BaseNetworkResult$Error;", "Luz/micro/star/lesson_41/retrofit/models/BaseNetworkResult$Loading;", "app_debug"})
public abstract class BaseNetworkResult<T extends java.lang.Object> {
    @org.jetbrains.annotations.Nullable()
    private final T data = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String message = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isLoading = null;
    
    private BaseNetworkResult(T data, java.lang.String message, java.lang.Boolean isLoading) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final T getData() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isLoading() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Luz/micro/star/lesson_41/retrofit/models/BaseNetworkResult$Success;", "T", "Luz/micro/star/lesson_41/retrofit/models/BaseNetworkResult;", "data", "(Ljava/lang/Object;)V", "app_debug"})
    public static final class Success<T extends java.lang.Object> extends uz.micro.star.lesson_41.retrofit.models.BaseNetworkResult<T> {
        
        public Success(T data) {
            super(null, null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Luz/micro/star/lesson_41/retrofit/models/BaseNetworkResult$Error;", "T", "Luz/micro/star/lesson_41/retrofit/models/BaseNetworkResult;", "message", "", "(Ljava/lang/String;)V", "app_debug"})
    public static final class Error<T extends java.lang.Object> extends uz.micro.star.lesson_41.retrofit.models.BaseNetworkResult<T> {
        
        public Error(@org.jetbrains.annotations.Nullable()
        java.lang.String message) {
            super(null, null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Luz/micro/star/lesson_41/retrofit/models/BaseNetworkResult$Loading;", "T", "Luz/micro/star/lesson_41/retrofit/models/BaseNetworkResult;", "isLoading", "", "(Ljava/lang/Boolean;)V", "app_debug"})
    public static final class Loading<T extends java.lang.Object> extends uz.micro.star.lesson_41.retrofit.models.BaseNetworkResult<T> {
        
        public Loading(@org.jetbrains.annotations.Nullable()
        java.lang.Boolean isLoading) {
            super(null, null, null);
        }
    }
}