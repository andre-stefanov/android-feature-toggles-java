package de.andrestefanov.android.featuretoggles.model.firebase;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import de.andrestefanov.android.featuretoggles.model.data.FeatureToggle;
import de.andrestefanov.android.featuretoggles.model.data.Profile;
import durdinapps.rxfirebase2.RxFirestore;
import io.reactivex.Flowable;

public class Api {

    private final FirebaseFirestore fireStore = FirebaseFirestore.getInstance();

    public Flowable<Boolean> isFeatureActive(String profileId, String featureFlag) {
        Query query = fireStore.collection("features")
                .whereEqualTo("profile", profileId)
                .whereEqualTo("flag", featureFlag);

        return RxFirestore.observeQueryRef(query)
                .map(snapshot -> snapshot.toObjects(FeatureToggle.class))
                .map(list -> !list.isEmpty());
    }

    public Flowable<Profile> profile(String profileId) {
        DocumentReference docRef = fireStore.collection("profiles").document(profileId);
        return RxFirestore.observeDocumentRef(docRef, Profile.class);
    }

}
