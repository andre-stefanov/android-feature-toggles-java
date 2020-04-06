package de.andrestefanov.android.featuretoggles.view.profile;

import android.view.View;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import de.andrestefanov.android.featuretoggles.features.profile.ProfileFeature;
import de.andrestefanov.android.featuretoggles.features.reputation.ProfileReputationFeature;
import de.andrestefanov.android.featuretoggles.features.reputation.ProfileReputationFeatureProvider;
import de.andrestefanov.android.featuretoggles.model.data.Profile;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class ProfileViewModel extends ViewModel {

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    private final LiveData<String> mail;
    private final MutableLiveData<String> reputation = new MutableLiveData<>();
    private final MutableLiveData<Integer> reputationVisibility = new MutableLiveData<>();

    @Inject
    ProfileViewModel(ProfileReputationFeatureProvider profileReputationFeatureProvider, ProfileFeature profileFeature) {

        //// Mail Feature
        mail = LiveDataReactiveStreams.fromPublisher(
                profileFeature.getProfile()
                        .map(optional -> optional
                                .map(Profile::getMail)
                                .orElse("Optional empty in ViewModel")
                        )
        );

        //// Reputation Feature -- TODO @Stevanof: Kann man das in einem Stream loesen?
        Flowable<ProfileReputationFeature> repFeature = profileReputationFeatureProvider
                .feature()
                .subscribeOn(Schedulers.io());

        // Feature active
        compositeDisposable.add(
                repFeature.filter(ProfileReputationFeature::isActive)
                        .switchMap(ProfileReputationFeature::getReputation)
                        .subscribe(optionalRep -> showReputation(optionalRep.orElse(0d)))
        );

        // Feature inactive
        compositeDisposable.add(
                repFeature.filter(feature -> !feature.isActive())
                        .subscribe(profileReputationFeature -> hideReputation())
        );
    }

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        super.onCleared();
    }

    public LiveData<String> getEmail() {
        return mail;
    }

    public LiveData<String> getReputation() {
        return reputation;
    }

    public LiveData<Integer> getReputationVisibility() {
        return reputationVisibility;
    }

    @WorkerThread
    private void showReputation(Double rep) {
        reputation.postValue(rep.toString());
        reputationVisibility.postValue(View.VISIBLE);
    }

    @WorkerThread
    private void hideReputation() {
        reputation.postValue(null);
        reputationVisibility.postValue(View.GONE);
    }
}
