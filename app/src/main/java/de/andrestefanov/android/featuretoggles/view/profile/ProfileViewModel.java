package de.andrestefanov.android.featuretoggles.view.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.Optional;

import javax.inject.Inject;

import de.andrestefanov.android.featuretoggles.features.reputation.ProfileReputationFeatureSwitch;
import de.andrestefanov.android.featuretoggles.features.reputation.ProfileReputationFeature;

public class ProfileViewModel extends ViewModel {

    private final ProfileReputationFeatureSwitch profileReputationFeatureProvider;

    @Inject
    ProfileViewModel(ProfileReputationFeatureSwitch profileReputationFeatureProvider) {
        this.profileReputationFeatureProvider = profileReputationFeatureProvider;
    }

    public LiveData<Double> getProfile() {
        LiveData<Optional<Double>> optionalLiveData = LiveDataReactiveStreams.fromPublisher(
                profileReputationFeatureProvider.feature().flatMap(ProfileReputationFeature::getReputation)
        );

        return Transformations.map(
                optionalLiveData,
                optional -> optional.orElse(null)
        );
    }

}
