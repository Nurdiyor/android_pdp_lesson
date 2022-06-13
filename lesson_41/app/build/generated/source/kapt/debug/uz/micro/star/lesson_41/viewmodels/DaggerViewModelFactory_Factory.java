// Generated by Dagger (https://dagger.dev).
package uz.micro.star.lesson_41.viewmodels;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerViewModelFactory_Factory implements Factory<DaggerViewModelFactory> {
  private final Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> viewModelsMapProvider;

  public DaggerViewModelFactory_Factory(
      Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> viewModelsMapProvider) {
    this.viewModelsMapProvider = viewModelsMapProvider;
  }

  @Override
  public DaggerViewModelFactory get() {
    return newInstance(viewModelsMapProvider.get());
  }

  public static DaggerViewModelFactory_Factory create(
      Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> viewModelsMapProvider) {
    return new DaggerViewModelFactory_Factory(viewModelsMapProvider);
  }

  public static DaggerViewModelFactory newInstance(
      Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelsMap) {
    return new DaggerViewModelFactory(viewModelsMap);
  }
}