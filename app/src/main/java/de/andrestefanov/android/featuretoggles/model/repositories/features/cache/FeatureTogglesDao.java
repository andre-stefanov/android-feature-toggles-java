package de.andrestefanov.android.featuretoggles.model.repositories.features.cache;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

import static androidx.room.OnConflictStrategy.IGNORE;

@Dao
public interface FeatureTogglesDao {

    @Query("select * from FeatureToggleEntity where profile = :profileId")
    Flowable<List<FeatureToggleEntity>> getTogglesForProfile(String profileId);

    @Insert(onConflict = IGNORE)
    Completable insert(FeatureToggleEntity entity);

    @Delete
    Completable delete(FeatureToggleEntity entity);

}
