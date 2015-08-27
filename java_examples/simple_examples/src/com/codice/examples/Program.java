package com.codice.examples;


import com.codice.examples.actions.CreateRepositoryAction;
import com.codice.examples.actions.RenameAction;
import com.codice.examples.models.Repository;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.List;
import java.util.Scanner;

public class Program {

    static IApi apiClient;
    static Scanner in;
    static String instructions = "1 - List repositories (cm lrep)\n" +
    "2 - Create a repository (cm mkrep)\n" +
    "3 - Rename a repository (cm rnrep)\n" +
    "4 - Delete a repository (cm rmrep)\n" +
    "\n"                                   +
    "Select an option (1/2/3/4): ";

    static void initApiClient() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://localhost:9090")
                .build();

        apiClient = adapter.create(IApi.class);
    }

    static void listRepositories() {
        List<Repository> repositories = apiClient.getRepositories();
        for(Repository repo : repositories) {
            System.out.println(String.format("%d_%d %s %s",
                    repo.getRepId().getId(),
                    repo.getRepId().getModuleId(),
                    repo.getName(),
                    repo.getServer()));
        }
    }

    static void createRepository() {
        System.out.print("Write a name for the repository: ");
        String name = in.nextLine();
        System.out.print("Write the direction of the server: ");
        String server = in.nextLine();

        CreateRepositoryAction action =
                new CreateRepositoryAction(name, server);

        Repository newRepo = apiClient.createRepository(action);
        System.out.println(String.format(
                "Repository %s successfully created!", newRepo.getName()));
    }

    static void renameRepository() {
        listRepositories();
        System.out.print("Write the name of the repository to rename: ");
        String repository = in.nextLine();
        System.out.print(String.format("Write a new name for %s: ", repository));
        String newName = in.nextLine();

        RenameAction action = new RenameAction(newName);
        Repository renamedRepo =
                apiClient.renameRepository(repository, action);
        System.out.println(
                String.format("Repository %s successfully renamed to %s.",
                        repository, renamedRepo.getName())
        );
    }

    static void deleteRepository() {
        listRepositories();
        System.out.print("Write the name of the repository to delete: ");
        String repository = in.nextLine();

        apiClient.deleteRepository(repository, new Callback<Void>() {
            @Override
            public void success(Void aVoid, Response response) {
                // Retrofit limitation. Here, we should only check the
                // status code.
                System.out.println("Repository successfully deleted!");
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        });
    }

    public static void main(String[] args) {
        initApiClient();

        System.out.print(instructions);
        in = new Scanner(System.in);
        String optionStr = in.nextLine();
        int option;

        try {
            option = Integer.valueOf(optionStr);
        } catch (NumberFormatException e) {
            option = 1;
        }

        switch (option) {
            case 1:
            default:
                listRepositories();
                break;
            case 2:
                createRepository();
                break;
            case 3:
                renameRepository();
                break;
            case 4:
                deleteRepository();
                break;
        }

    }
}
