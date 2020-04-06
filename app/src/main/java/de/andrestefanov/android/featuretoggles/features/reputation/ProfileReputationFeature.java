package de.andrestefanov.android.featuretoggles.features.reputation;

import java.util.Optional;

import io.reactivex.Flowable;

public interface ProfileReputationFeature {

    Flowable<Optional<Double>> getReputation();

}
