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

    public Flowable<Optional<String>> currentUser() {
        // TODO: 9.3.20 implement a dummy authentication
        return Flowable.<Optional<String>>never().startWith(Optional.of("alice"));
    }

}
