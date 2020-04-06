package de.andrestefanov.android.featuretoggles.features.reputation;

import java.util.Optional;

import io.reactivex.Flowable;

public class ProfileReputationFeatureNoop implements ProfileReputationFeature {

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public Flowable<Optional<Double>> getReputation() {
        return Flowable.just(Optional.empty());
    }

}
