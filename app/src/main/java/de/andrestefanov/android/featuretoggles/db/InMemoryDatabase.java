package de.andrestefanov.android.featuretoggles.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import de.andrestefanov.android.featuretoggles.model.repositories.features.cache.FeatureToggleEntity;
import de.andrestefanov.android.featuretoggles.model.repositories.features.cache.FeatureTogglesDao;

@Database(
        entities = {
                FeatureToggleEntity.class
        },
        version = 1,
        exportSchema = false
)
public abstract class InMemoryDatabase extends RoomDatabase {

    public abstract FeatureTogglesDao featuresDao();

}
