package uz.micro.star.lesson_41.di.module;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import uz.micro.star.lesson_41.MainActivity;

@Module(
  subcomponents = ActivityBuildersModule_ContributeMainActivity.MainActivitySubcomponent.class
)
public abstract class ActivityBuildersModule_ContributeMainActivity {
  private ActivityBuildersModule_ContributeMainActivity() {}

  @Binds
  @IntoMap
  @ClassKey(MainActivity.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MainActivitySubcomponent.Factory builder);

  @Subcomponent(modules = {ViewModelsModule.class, MainFragmentBuildersModule.class})
  public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainActivity> {}
  }
}
