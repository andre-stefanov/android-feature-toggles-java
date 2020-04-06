package de.andrestefanov.android.featuretoggles.view;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import de.andrestefanov.android.featuretoggles.view.profile.ProfileFragmentModule;

@Subcomponent(
        modules = ProfileFragmentModule.class
)
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainActivity> {}

}
