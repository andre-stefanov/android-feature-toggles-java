package de.andrestefanov.android.featuretoggles.model.repositories.auth;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

@Singleton
public class AuthRepository {

    @Inject
    AuthRepository() {

    }

    public Flowable<Optional<String>> currentProfileId() {
        return Flowable.<Optional<String>>never().startWith(Optional.of("ykzqhp7iGh33bodvkup7"));
    }

}
