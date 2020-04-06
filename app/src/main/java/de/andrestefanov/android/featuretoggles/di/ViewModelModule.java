package de.andrestefanov.android.featuretoggles.di;

import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import de.andrestefanov.android.featuretoggles.view.ViewModelFactory;

@Module
public interface ViewModelModule {

    @Binds
    ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

}
