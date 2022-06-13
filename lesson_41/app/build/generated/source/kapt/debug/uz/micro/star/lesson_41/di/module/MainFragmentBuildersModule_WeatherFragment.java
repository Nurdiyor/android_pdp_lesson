package uz.micro.star.lesson_41.di.module;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import uz.micro.star.lesson_41.fragments.WeatherFragment;

@Module(
  subcomponents = MainFragmentBuildersModule_WeatherFragment.WeatherFragmentSubcomponent.class
)
public abstract class MainFragmentBuildersModule_WeatherFragment {
  private MainFragmentBuildersModule_WeatherFragment() {}

  @Binds
  @IntoMap
  @ClassKey(WeatherFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      WeatherFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface WeatherFragmentSubcomponent extends AndroidInjector<WeatherFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<WeatherFragment> {}
  }
}
