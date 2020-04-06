package de.andrestefanov.android.featuretoggles.model.rest;

import androidx.annotation.NonNull;

import de.andrestefanov.android.featuretoggles.model.data.FeaturesResponse;
import de.andrestefanov.android.featuretoggles.model.data.QueryResult;
import de.andrestefanov.android.featuretoggles.model.data.Repository;
import io.reactivex.Single;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class RestClient {

    private final GitHubService gitHubService;

    private final FeaturesService featuresService;

    public RestClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        Retrofit gitHubRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(client)
                .build();

        gitHubService = gitHubRetrofit.create(GitHubService.class);

        Retrofit featuresRetrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/andre-stefanov/android-feature-toggles/master/sample-data/")
                .client(client)
                .build();

        featuresService = featuresRetrofit.create(FeaturesService.class);
    }

    public Single<QueryResult<Repository>> searchRepositories(String query, String sort, String order) {
        return gitHubService.queryRepositories(query, sort, order);
    }

    public Single<FeaturesResponse> getUserFeatures(@NonNull String user) {
        return featuresService.getUserFeatures(user);
    }
}
