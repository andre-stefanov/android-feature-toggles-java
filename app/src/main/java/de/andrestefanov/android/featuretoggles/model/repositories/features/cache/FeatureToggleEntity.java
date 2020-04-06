package de.andrestefanov.android.featuretoggles.model.repositories.features.cache;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import de.andrestefanov.android.featuretoggles.model.data.FeatureToggle;

@Entity
public class FeatureToggleEntity {

    @PrimaryKey
    public int id;

    @Embedded
    FeatureToggle featureToggle;

}
