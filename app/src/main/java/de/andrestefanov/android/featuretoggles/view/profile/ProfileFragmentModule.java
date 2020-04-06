package de.andrestefanov.android.featuretoggles.view.profile;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
        subcomponents = ProfileFragmentComponent.class
)
public abstract class ProfileFragmentModule {

    @Binds
    @IntoMap
    @ClassKey(ProfileFragment.class)
    abstract AndroidInjector.Factory<?> bindProfileFragmentInjectorFactory(ProfileFragmentComponent.Factory factory);

}
