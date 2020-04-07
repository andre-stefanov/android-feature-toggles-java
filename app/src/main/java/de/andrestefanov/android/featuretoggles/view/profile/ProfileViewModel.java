package de.andrestefanov.android.featuretoggles.view.profile;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.ViewModel;

import java.util.Optional;

import javax.inject.Inject;

import de.andrestefanov.android.featuretoggles.features.profile.ProfileFeature;
import de.andrestefanov.android.featuretoggles.features.reputation.ProfileReputationFeature;
import de.andrestefanov.android.featuretoggles.features.reputation.ProfileReputationFeatureProvider;
import de.andrestefanov.android.featuretoggles.model.data.Profile;
import io.reactivex.Flowable;

public class ProfileViewModel extends ViewModel {

    private final LiveData<String> mail;
    private final LiveData<String> reputation;
    private final LiveData<Integer> reputationVisibility;

    @Inject
    ProfileViewModel(ProfileReputationFeatureProvider profileReputationFeatureProvider, ProfileFeature profileFeature) {

        // Mail Feature
        mail = LiveDataReactiveStreams.fromPublisher(
                profileFeature.getProfile()
                        .map(optional -> optional
                                .map(Profile::getMail)
                                .orElse("Email missing")
                        )
        );

        // Reputation Feature
        Flowable<Optional<Double>> reputationOptionalFlowable = profileReputationFeatureProvider
                .feature()
                .flatMap(ProfileReputationFeature::getReputation);

        Flowable<String> reputationFlowable = reputationOptionalFlowable
                .map(optional -> optional.orElse(0.0))
                .map(String::valueOf);

        reputation = LiveDataReactiveStreams.fromPublisher(reputationFlowable);

        Flowable<Integer> reputationVisibilityFlowable = reputationOptionalFlowable
                .map(Optional::isPresent)
                .map(visible -> (visible) ? View.VISIBLE : View.GONE);

        reputationVisibility = LiveDataReactiveStreams.fromPublisher(reputationVisibilityFlowable);
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

}
