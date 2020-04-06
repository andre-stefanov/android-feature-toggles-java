package de.andrestefanov.android.featuretoggles.model.data;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Profile {

    private String mail;

    private Double reputation;

    public Profile() {

    }

    public Profile(String mail, Double reputation) {
        this.mail = mail;
        this.reputation = reputation;
    }

    public String getMail() {
        return mail;
    }

    public Double getReputation() {
        return reputation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(mail, profile.mail) &&
                Objects.equals(reputation, profile.reputation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail, reputation);
    }

    @NonNull
    @Override
    public String toString() {
        return "Profile{" +
                "mail='" + mail + '\'' +
                ", reputation=" + reputation +
                '}';
    }
}
