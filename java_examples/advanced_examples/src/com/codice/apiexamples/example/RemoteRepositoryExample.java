package com.codice.apiexamples.example;

import com.codice.apiexamples.api.ApiService;
import com.codice.apiexamples.api.actions.CreateBranchAction;
import com.codice.apiexamples.api.actions.CreateRepositoryAction;
import com.codice.apiexamples.api.models.Repository;
import com.codice.apiexamples.example.utils.StdUtils;
import com.codice.apiexamples.example.utils.Utils;
import retrofit.RetrofitError;


/**
 * An example showing how the API is capable of managing repositories hosted in other server
 * rather than the default one.
 */
public class RemoteRepositoryExample {

    private static ApiService api;
    private static Repository repository;

    private static void createRemoteRepositoryExample() throws RetrofitError {
        String serverUrl = StdUtils.readStringFromConsole("Write a PlasticSCM server address: ");
        String repositoryName = StdUtils.readStringFromConsole(
                "Write a name for the new repository at " + serverUrl + ": ");

        CreateRepositoryAction createAction = new CreateRepositoryAction(repositoryName, serverUrl);
        repository = api.createRepository(createAction);
    }

    private static void createBranchesInRemoteRepositoryExample() throws RetrofitError {
        CreateBranchAction createBranch1 =
                CreateBranchAction.buildCreateBranchFromBranchAction("scm001", "/main");
        CreateBranchAction createBranch2 =
                CreateBranchAction.buildCreateBranchFromBranchAction("scm002", "/main");
        CreateBranchAction createBranch3 =
                CreateBranchAction.buildCreateBranchFromBranchAction("scm003", "/main/scm002");

        System.out.println("Creating three branches in " + repository.getCompleteName() + "\n");

        StdUtils.printBranchInformation(
                api.createBranch(repository.getCompleteName(), createBranch1));
        StdUtils.printBranchInformation(
                api.createBranch(repository.getCompleteName(), createBranch2));
        StdUtils.printBranchInformation(
                api.createBranch(repository.getCompleteName(), createBranch3));
    }

    public static void main(String[] args) {
        api = Utils.getApiInstance();

        try {
            createRemoteRepositoryExample();
            createBranchesInRemoteRepositoryExample();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
