package de.andrestefanov.android.featuretoggles.di;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.andrestefanov.android.featuretoggles.App;
import de.andrestefanov.android.featuretoggles.db.InMemoryDatabase;
import de.andrestefanov.android.featuretoggles.model.rest.RestClient;
import de.andrestefanov.android.featuretoggles.model.repositories.features.cache.FeatureTogglesDao;

@Module
class AppModule {

    @Provides
    RestClient provideRestClient() {
        return new RestClient();
    }

    @Provides
    @Singleton
    InMemoryDatabase provideInMemoryDatabase(App app) {
        return Room.inMemoryDatabaseBuilder(app.getApplicationContext(), InMemoryDatabase.class)
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    FeatureTogglesDao provideFeaturesDao(InMemoryDatabase db) {
        return db.featuresDao();
    }

}
