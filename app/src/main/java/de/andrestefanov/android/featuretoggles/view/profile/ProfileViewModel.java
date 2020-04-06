package de.andrestefanov.android.featuretoggles.view.profile;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import de.andrestefanov.android.featuretoggles.features.profile.ProfileFeature;
import de.andrestefanov.android.featuretoggles.features.reputation.ProfileReputationFeature;
import de.andrestefanov.android.featuretoggles.features.reputation.ProfileReputationFeatureProvider;
import de.andrestefanov.android.featuretoggles.model.data.Profile;
import io.reactivex.Flowable;

public class ProfileViewModel extends ViewModel {

    private final ProfileReputationFeatureProvider profileReputationFeatureProvider;
    private final ProfileFeature profileFeature;

    @Inject
    ProfileViewModel(ProfileReputationFeatureProvider profileReputationFeatureProvider, ProfileFeature profileFeature) {
        this.profileReputationFeatureProvider = profileReputationFeatureProvider;
        this.profileFeature = profileFeature;
    }

    public LiveData<String> getEmail() {
        return LiveDataReactiveStreams.fromPublisher(
                profileFeature.getProfile()
                        .doOnNext(o -> Log.d("ZEFIX", o.toString()))
                        .map(optional -> optional
                                .map(Profile::getMail)
                                .orElse("")));
    }

    public LiveData<String> getReputation() {
        Flowable<String> flowable = profileReputationFeatureProvider.feature()
                .flatMap(ProfileReputationFeature::getReputation)
                .map(optional -> optional.map(String::valueOf).orElse(""));

        return LiveDataReactiveStreams.fromPublisher(flowable);
    }

}
