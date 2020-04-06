package de.andrestefanov.android.featuretoggles.model.rest;

import androidx.annotation.NonNull;

import de.andrestefanov.android.featuretoggles.model.data.FeaturesResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface FeaturesService {

    @GET("features/{user}.json")
    Single<FeaturesResponse> getUserFeatures(@NonNull @Path("user") String user);

}
