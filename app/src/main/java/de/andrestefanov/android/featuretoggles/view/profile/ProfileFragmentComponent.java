package de.andrestefanov.android.featuretoggles.view.profile;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface ProfileFragmentComponent extends AndroidInjector<ProfileFragment> {

    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<ProfileFragment> {}

}
