package uz.micro.star.lesson_41.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B1\u0012*\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\t\u00a2\u0006\u0002\u0010\nJ&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u00072\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u0010(\u001a\u00020)H&J\u001a\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016R\u0012\u0010\u000b\u001a\u0004\u0018\u00018\u0000X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u0011\u0010\r\u001a\u00028\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR2\u0010\u0004\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006,"}, d2 = {"Luz/micro/star/lesson_41/fragments/BaseFragment;", "VB", "Landroidx/viewbinding/ViewBinding;", "Ldagger/android/support/DaggerFragment;", "inflate", "Lkotlin/Function3;", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "", "Luz/micro/star/lesson_41/fragments/Inflate;", "(Lkotlin/jvm/functions/Function3;)V", "_binding", "Landroidx/viewbinding/ViewBinding;", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "navController", "Landroidx/navigation/NavController;", "getNavController", "()Landroidx/navigation/NavController;", "setNavController", "(Landroidx/navigation/NavController;)V", "providerFactory", "Luz/micro/star/lesson_41/viewmodels/DaggerViewModelFactory;", "getProviderFactory", "()Luz/micro/star/lesson_41/viewmodels/DaggerViewModelFactory;", "setProviderFactory", "(Luz/micro/star/lesson_41/viewmodels/DaggerViewModelFactory;)V", "viewModel", "Luz/micro/star/lesson_41/viewmodels/ActivityViewModel;", "getViewModel", "()Luz/micro/star/lesson_41/viewmodels/ActivityViewModel;", "setViewModel", "(Luz/micro/star/lesson_41/viewmodels/ActivityViewModel;)V", "onCreateView", "Landroid/view/View;", "inflater", "container", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreate", "", "onViewCreated", "view", "app_debug"})
public abstract class BaseFragment<VB extends androidx.viewbinding.ViewBinding> extends dagger.android.support.DaggerFragment {
    private final kotlin.jvm.functions.Function3<android.view.LayoutInflater, android.view.ViewGroup, java.lang.Boolean, VB> inflate = null;
    private VB _binding;
    public uz.micro.star.lesson_41.viewmodels.ActivityViewModel viewModel;
    public androidx.navigation.NavController navController;
    @javax.inject.Inject()
    public uz.micro.star.lesson_41.viewmodels.DaggerViewModelFactory providerFactory;
    
    public BaseFragment(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super android.view.LayoutInflater, ? super android.view.ViewGroup, ? super java.lang.Boolean, ? extends VB> inflate) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final VB getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final uz.micro.star.lesson_41.viewmodels.ActivityViewModel getViewModel() {
        return null;
    }
    
    public final void setViewModel(@org.jetbrains.annotations.NotNull()
    uz.micro.star.lesson_41.viewmodels.ActivityViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.navigation.NavController getNavController() {
        return null;
    }
    
    public final void setNavController(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final uz.micro.star.lesson_41.viewmodels.DaggerViewModelFactory getProviderFactory() {
        return null;
    }
    
    public final void setProviderFactory(@org.jetbrains.annotations.NotNull()
    uz.micro.star.lesson_41.viewmodels.DaggerViewModelFactory p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public abstract void onViewCreate();
}