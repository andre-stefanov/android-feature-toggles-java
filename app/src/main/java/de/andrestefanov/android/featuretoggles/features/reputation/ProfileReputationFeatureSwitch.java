package de.andrestefanov.android.featuretoggles.features.reputation;

import javax.inject.Inject;

import de.andrestefanov.android.featuretoggles.model.repositories.features.FeaturesRepository;
import de.andrestefanov.android.featuretoggles.model.repositories.profile.ProfileRepository;
import io.reactivex.Flowable;

public class ProfileReputationFeatureSwitch {

    private static final String FEATURE_FLAG = "feature.1.reputation";

    private final FeaturesRepository repository;

    private final ProfileRepository profileRepository;

    @Inject
    public ProfileReputationFeatureSwitch(FeaturesRepository repository, ProfileRepository profileRepository) {
        this.repository = repository;
        this.profileRepository = profileRepository;
    }

    public Flowable<ProfileReputationFeature> feature() {
        return repository.isFeatureToggleActive(FEATURE_FLAG)
                .map(isActive -> {
                    if (isActive) {
                        return new ProfileReputationFeatureImpl(profileRepository);
                    } else {
                        return new ProfileReputationFeatureNoop();
                    }
                });
    }
}
