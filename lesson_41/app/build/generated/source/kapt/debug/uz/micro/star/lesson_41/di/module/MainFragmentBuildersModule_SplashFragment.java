package uz.micro.star.lesson_41.di.module;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import uz.micro.star.lesson_41.fragments.SplashFragment;

@Module(subcomponents = MainFragmentBuildersModule_SplashFragment.SplashFragmentSubcomponent.class)
public abstract class MainFragmentBuildersModule_SplashFragment {
  private MainFragmentBuildersModule_SplashFragment() {}

  @Binds
  @IntoMap
  @ClassKey(SplashFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      SplashFragmentSubcomponent.Factory builder);

  @Subcomponent
  public interface SplashFragmentSubcomponent extends AndroidInjector<SplashFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<SplashFragment> {}
  }
}
