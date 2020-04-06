package de.andrestefanov.android.featuretoggles.features.profile;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.andrestefanov.android.featuretoggles.model.data.Profile;
import de.andrestefanov.android.featuretoggles.model.repositories.profile.ProfileRepository;
import io.reactivex.Flowable;

@Singleton
public class ProfileFeature {

    private final ProfileRepository repository;

    @Inject
    ProfileFeature(ProfileRepository repository) {
        this.repository = repository;
    }

    public Flowable<Optional<Profile>> getProfile() {
        return repository.profile();
    }

}
