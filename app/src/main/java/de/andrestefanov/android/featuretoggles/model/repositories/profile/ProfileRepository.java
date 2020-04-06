package de.andrestefanov.android.featuretoggles.model.repositories.profile;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.andrestefanov.android.featuretoggles.model.data.Profile;
import de.andrestefanov.android.featuretoggles.model.firebase.Api;
import de.andrestefanov.android.featuretoggles.model.repositories.auth.AuthRepository;
import io.reactivex.Flowable;
import io.reactivex.processors.BehaviorProcessor;

@Singleton
public class ProfileRepository {

    private final Api api;

    private final AuthRepository authRepository;

    @Inject
    ProfileRepository(Api api, AuthRepository authRepository) {
        this.api = api;
        this.authRepository = authRepository;
    }

    public Flowable<Optional<Profile>> profile() {
        return authRepository.currentProfileId().flatMap(optional -> {
                    if (optional.isPresent()) {
                        return api.profile(optional.get()).map(Optional::of);
                    } else {
                        return BehaviorProcessor.createDefault(Optional.empty());
                    }
                }
        );
    }

}
