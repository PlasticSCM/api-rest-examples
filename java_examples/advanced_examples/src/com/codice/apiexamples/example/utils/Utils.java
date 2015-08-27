package com.codice.apiexamples.example.utils;

import com.codice.apiexamples.api.ApiService;
import com.codice.apiexamples.api.models.Branch;
import com.codice.apiexamples.api.models.Repository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

import java.util.List;

/**
 * Generic Utils class.
 */
public class Utils {

    public static ApiService getApiInstance() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://localhost:9090")
                .setConverter(new GsonConverter(gson))
                .build();

        return adapter.create(ApiService.class);
    }

    public static Repository filterRepoById(List<Repository> repositories, int id) {
        for (Repository repo : repositories)
            if (repo.getRepid().getId() == id) {
                return repo;
            }
        return null;
    }

    public static Branch filterBranchById(List<Branch> branches, int id) {
        for (Branch branch : branches) {
            if (branch.getId() == id) {
                return branch;
            }
        }
        return null;
    }
}
