package de.andrestefanov.android.featuretoggles.model.data;

import androidx.annotation.NonNull;

import java.util.Objects;

@SuppressWarnings("unused")
public class FeatureToggle {

    private String id;

    private String flag;

    private String profile;

    public FeatureToggle() {
        id = "";
        flag = "";
        profile = "";
    }

    public FeatureToggle(String id, String flag, String profile) {
        this.id = id;
        this.flag = flag;
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public String getFlag() {
        return flag;
    }

    public String getProfile() {
        return profile;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeatureToggle that = (FeatureToggle) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(flag, that.flag) &&
                Objects.equals(profile, that.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flag, profile);
    }

    @NonNull
    @Override
    public String toString() {
        return "FeatureToggle{" +
                "id='" + id + '\'' +
                ", flag='" + flag + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}
