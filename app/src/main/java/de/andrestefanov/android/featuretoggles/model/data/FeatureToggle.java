package de.andrestefanov.android.featuretoggles.model.data;

import java.util.Objects;

public class FeatureToggle {

    private final String key;

    private final String profile;

    public FeatureToggle(String key, String profile) {
        this.key = key;
        this.profile = profile;
    }

    public String getKey() {
        return key;
    }

    public String getProfile() {
        return profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeatureToggle feature = (FeatureToggle) o;
        return Objects.equals(key, feature.key) &&
                Objects.equals(profile, feature.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, profile);
    }



}
