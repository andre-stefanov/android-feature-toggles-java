package de.andrestefanov.android.featuretoggles.model.repositories.features;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.andrestefanov.android.featuretoggles.model.rest.RestClient;
import de.andrestefanov.android.featuretoggles.model.data.FeaturesResponse;
import de.andrestefanov.android.featuretoggles.model.repositories.auth.AuthRepository;
import de.andrestefanov.android.featuretoggles.model.repositories.features.cache.FeatureTogglesDao;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Singleton
public class FeaturesRepository {

    private final RestClient rest;

    private final AuthRepository authRepository;

    private final FeatureTogglesDao cache;

    @Inject
    FeaturesRepository(RestClient rest, FeatureTogglesDao cache, AuthRepository authRepository) {
        this.rest = rest;
        this.authRepository = authRepository;
        this.cache = cache;
    }

    public Flowable<List<String>> activeFeatureToggles() {
        return authRepository.currentUser()
                .switchMapSingle(profileOptional ->
                        profileOptional.map(rest::getUserFeatures)
                                .orElse(Single.just(FeaturesResponse.EMPTY)))
                .map(FeaturesResponse::getActiveFeatures);
    }

}
