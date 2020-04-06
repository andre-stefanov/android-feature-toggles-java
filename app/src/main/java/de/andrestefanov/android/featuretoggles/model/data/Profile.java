package de.andrestefanov.android.featuretoggles.model.data;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Profile {

    private String mail;

    private String imageUrl100;

    private String imageUrl500;

    private Double reputation;

    public Profile(String mail, String imageUrl100, String imageUrl500, Double reputation) {
        this.mail = mail;
        this.imageUrl100 = imageUrl100;
        this.imageUrl500 = imageUrl500;
        this.reputation = reputation;
    }

    public String getMail() {
        return mail;
    }

    public String getImageUrl100() {
        return imageUrl100;
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
                Objects.equals(imageUrl100, profile.imageUrl100) &&
                Objects.equals(imageUrl500, profile.imageUrl500) &&
                Objects.equals(reputation, profile.reputation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mail, imageUrl100, imageUrl500, reputation);
    }

    @Override
    @NonNull
    public String toString() {
        return "Profile{" +
                "mail='" + mail + '\'' +
                ", imageUrl100='" + imageUrl100 + '\'' +
                ", imageUrl500='" + imageUrl500 + '\'' +
                ", reputation=" + reputation +
                '}';
    }
}
