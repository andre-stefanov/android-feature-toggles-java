package de.andrestefanov.android.featuretoggles.model.repositories.profile;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

import de.andrestefanov.android.featuretoggles.db.InMemoryDatabase;
import de.andrestefanov.android.featuretoggles.model.data.Profile;
import io.reactivex.Flowable;

@Singleton
public class ProfileStorage {

    private final InMemoryDatabase inMemoryDatabase;

    @Inject
    public ProfileStorage(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    Flowable<Optional<Profile>> getProfile(String profileId) {
        return Flowable.never(); // TODO: 9.3.20
    }
    
}
