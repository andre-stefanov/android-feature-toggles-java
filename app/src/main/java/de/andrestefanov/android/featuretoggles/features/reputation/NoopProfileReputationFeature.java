package de.andrestefanov.android.featuretoggles.features.reputation;

import java.util.Optional;

import javax.inject.Singleton;

import io.reactivex.Flowable;

@Singleton
public class NoopProfileReputationFeature implements ProfileReputationFeature {

    @Override
    public Flowable<Optional<Double>> getReputation() {
        return Flowable.<Optional<Double>>empty().startWith(Optional.empty());
    }

}
