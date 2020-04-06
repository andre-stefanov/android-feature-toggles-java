package de.andrestefanov.android.featuretoggles.features.reputation;

import javax.inject.Inject;

import de.andrestefanov.android.featuretoggles.model.repositories.features.FeaturesRepository;
import de.andrestefanov.android.featuretoggles.model.repositories.profile.ProfileRepository;
import io.reactivex.Flowable;

public class ProfileReputatinFeatureSwitch {

    private final FeaturesRepository repository;

    private final ProfileRepository profileRepository;

    @Inject
    public ProfileReputatinFeatureSwitch(FeaturesRepository repository, ProfileRepository profileRepository) {
        this.repository = repository;
        this.profileRepository = profileRepository;
    }

    public Flowable<ProfileReputationFeature> feature() {
        return repository.activeFeatureToggles().map(list -> list.contains("feature.12345.rreputation"))
                .map(isActive -> {
                    if (isActive) {
                        return new SimpleProfileReputationFeature(profileRepository);
                    } else {
                        return new NoopProfileReputationFeature();
                    }
                });
    }
}
