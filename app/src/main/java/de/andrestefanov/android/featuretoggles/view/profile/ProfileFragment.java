package de.andrestefanov.android.featuretoggles.view.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;
import de.andrestefanov.android.featuretoggles.databinding.ProfileFragmentBinding;
import de.andrestefanov.android.featuretoggles.di.scope.ActivityScope;

@ActivityScope
public class ProfileFragment extends DaggerFragment {

    @Inject
    ProfileViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        de.andrestefanov.android.featuretoggles.databinding.ProfileFragmentBinding binding = ProfileFragmentBinding.inflate(inflater, container, false);

        binding.setViewmodel(viewModel);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        viewModel.getProfile().observe(this.getViewLifecycleOwner(), binding::setViewState);
    }

}
