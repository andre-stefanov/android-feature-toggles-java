package de.andrestefanov.android.featuretoggles.model.repositories.auth;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.processors.BehaviorProcessor;

@Singleton
public class AuthRepository {

    @Inject
    AuthRepository() {

    }

    public Flowable<Optional<String>> currentProfileId() {
        return BehaviorProcessor.createDefault(Optional.of("ykzqhp7iGh33bodvkup7"));
    }

}
