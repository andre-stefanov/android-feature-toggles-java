package de.andrestefanov.android.featuretoggles.model.repositories.profile;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.andrestefanov.android.featuretoggles.model.rest.RestClient;
import de.andrestefanov.android.featuretoggles.model.data.Profile;
import de.andrestefanov.android.featuretoggles.model.repositories.auth.AuthRepository;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.processors.BehaviorProcessor;

@Singleton
public class ProfileRepository {

    private final RestClient api;

    private final ProfileStorage storage;

    private final AuthRepository authRepository;

    @Inject
    ProfileRepository(RestClient api,
                      ProfileStorage storage,
                      AuthRepository authRepository) {
        this.api = api;
        this.storage = storage;
        this.authRepository = authRepository;
    }

    public Flowable<Optional<Profile>> profile() {
        return authRepository.currentUser()
                .flatMap(profileId ->
                        profileId.map(storage::getProfile)
                                .orElse(BehaviorProcessor.createDefault(Optional.empty())));
    }

    public Completable reloadData() {
        // TODO: 10.3.20
        return Completable.error(new IllegalStateException("not implemented"));
    }

}
