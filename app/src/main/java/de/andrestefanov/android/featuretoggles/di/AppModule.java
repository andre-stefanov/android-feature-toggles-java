package de.andrestefanov.android.featuretoggles.di;

import dagger.Module;
import dagger.Provides;
import de.andrestefanov.android.featuretoggles.model.firebase.Api;

@Module
class AppModule {

    @Provides
    Api provideApi() {
        return new Api();
    }

}
