package de.andrestefanov.android.featuretoggles.model.data;

import java.util.ArrayList;
import java.util.List;

public class FeaturesResponse {

    public static final FeaturesResponse EMPTY = new FeaturesResponse();

    private List<String> activeFeatures;

    private FeaturesResponse() {
        activeFeatures = new ArrayList<>();
    }

    public List<String> getActiveFeatures() {
        return activeFeatures;
    }

}
