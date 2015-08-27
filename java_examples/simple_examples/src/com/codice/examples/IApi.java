package com.codice.examples;


import com.codice.examples.actions.CreateRepositoryAction;
import com.codice.examples.actions.RenameAction;
import com.codice.examples.models.Repository;
import retrofit.Callback;
import retrofit.http.*;

import java.util.List;

public interface IApi {

    @GET("/api/v1/repos")
    List<Repository> getRepositories();

    @POST("/api/v1/repos")
    Repository createRepository(@Body CreateRepositoryAction params);

    @PUT("/api/v1/repos/{repname}")
    Repository renameRepository(@Path("repname") String repositoryName,
                                @Body RenameAction params);

    @DELETE("/api/v1/repos/{repname}")
    void deleteRepository(@Path("repname") String repositoryName,
                          Callback<Void> callback); // Retrofit limitation.
}
