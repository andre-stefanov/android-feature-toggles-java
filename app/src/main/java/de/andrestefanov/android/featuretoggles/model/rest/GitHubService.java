package de.andrestefanov.android.featuretoggles.model.rest;

import de.andrestefanov.android.featuretoggles.model.data.QueryResult;
import de.andrestefanov.android.featuretoggles.model.data.Repository;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface GitHubService {

    @GET("search/repositories")
    Single<QueryResult<Repository>> queryRepositories(@Query("q") String query,
                                                      @Query("sort") String sort,
                                                      @Query("order") String order);

}
