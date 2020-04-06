package de.andrestefanov.android.featuretoggles.di;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import de.andrestefanov.android.featuretoggles.App;
import de.andrestefanov.android.featuretoggles.view.MainActivityModule;

@Singleton
@Component(modules = {
        AppModule.class,
        AndroidInjectionModule.class,
        MainActivityModule.class,
        ViewModelModule.class
})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Factory
    interface Factory extends AndroidInjector.Factory<App> {

        @Override
        AppComponent create(@BindsInstance App instance);

    }

}
