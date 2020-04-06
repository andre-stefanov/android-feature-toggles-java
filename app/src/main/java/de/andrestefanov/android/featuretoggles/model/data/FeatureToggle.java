package de.andrestefanov.android.featuretoggles.model.data;

import java.util.Objects;

public class FeatureToggle {

    private final String flag;

    private final String profile;

    public FeatureToggle(String flag, String profile) {
        this.flag = flag;
        this.profile = profile;
    }

    public String getFlag() {
        return flag;
    }

    public String getProfile() {
        return profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeatureToggle feature = (FeatureToggle) o;
        return Objects.equals(flag, feature.flag) &&
                Objects.equals(profile, feature.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flag, profile);
    }



}
