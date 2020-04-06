package de.andrestefanov.android.featuretoggles.features.reputation;

import java.util.Optional;

import de.andrestefanov.android.featuretoggles.model.data.Profile;
import de.andrestefanov.android.featuretoggles.model.repositories.profile.ProfileRepository;
import io.reactivex.Flowable;

public class ProfileReputationFeatureImpl implements ProfileReputationFeature {

    private final ProfileRepository profileRepository;

    ProfileReputationFeatureImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public Flowable<Optional<Double>> getReputation() {
        return profileRepository.profile().map(profile -> profile.map(Profile::getReputation));
    }
}
