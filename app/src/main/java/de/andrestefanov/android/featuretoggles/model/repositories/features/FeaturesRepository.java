package de.andrestefanov.android.featuretoggles.model.repositories.features;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.andrestefanov.android.featuretoggles.model.firebase.Api;
import de.andrestefanov.android.featuretoggles.model.repositories.auth.AuthRepository;
import io.reactivex.Flowable;
import io.reactivex.processors.BehaviorProcessor;

@Singleton
public class FeaturesRepository {

    private final Api api;

    private final AuthRepository authRepository;

    @Inject
    FeaturesRepository(Api api, AuthRepository authRepository) {
        this.api = api;
        this.authRepository = authRepository;
    }

    public Flowable<Boolean> isFeatureToggleActive(String flag) {
        return authRepository.currentProfileId().flatMap(optional -> {
                    if (optional.isPresent()) {
                        return api.isFeatureActive(optional.get(), flag);
                    } else {
                        return BehaviorProcessor.createDefault(false);
                    }
                }
        );
    }

}
