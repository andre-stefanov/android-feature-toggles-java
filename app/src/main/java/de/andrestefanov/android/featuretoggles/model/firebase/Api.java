package de.andrestefanov.android.featuretoggles.model.firebase;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import de.andrestefanov.android.featuretoggles.model.data.FeatureToggle;
import de.andrestefanov.android.featuretoggles.model.data.Profile;
import durdinapps.rxfirebase2.RxFirestore;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public class Api {

    private final FirebaseFirestore fireStore = FirebaseFirestore.getInstance();

    public Api() {
        CollectionReference profileCollection = fireStore.collection("profile");
        RxFirestore.observeQueryRef(profileCollection)
                .firstElement()
                .filter(QuerySnapshot::isEmpty)
                .flatMapCompletable(this::initDummyData)
                .subscribe();
    }

    public Flowable<Boolean> isFeatureActive(String profileId, String featureFlag) {
        Query query = fireStore.collection("features")
                .whereEqualTo("profile", profileId)
                .whereEqualTo("flag", featureFlag);

        return RxFirestore.observeQueryRef(query)
                .map(snapshot -> snapshot.toObjects(FeatureToggle.class))
                .map(list -> !list.isEmpty());
    }

    public Flowable<Profile> profile(String profileId) {
        DocumentReference docRef = fireStore.collection("profile").document(profileId);
        return RxFirestore.observeDocumentRef(docRef, Profile.class);
    }

    private Completable initDummyData(QuerySnapshot queryDocumentSnapshots) {
        CollectionReference profileCollection = fireStore.collection("profile");
        CollectionReference featuresCollection = fireStore.collection("features");

        Single<DocumentReference> createProfile = RxFirestore.addDocument(
                profileCollection,
                new Profile("alice@example.com", 0.9));

        Single<DocumentReference> addFeatureToggle = createProfile.flatMap(profile ->
                RxFirestore.addDocument(
                        featuresCollection,
                        new FeatureToggle("", "feature.1.reputation", profile.getId())
                ));

        return addFeatureToggle.ignoreElement();
    }

}
