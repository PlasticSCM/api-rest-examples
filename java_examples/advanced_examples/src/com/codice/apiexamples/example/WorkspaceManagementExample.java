package com.codice.apiexamples.example;

import com.codice.apiexamples.api.ApiService;
import com.codice.apiexamples.api.actions.AddItemAction;
import com.codice.apiexamples.api.actions.CheckinAction;
import com.codice.apiexamples.api.actions.CreateWorkspaceAction;
import com.codice.apiexamples.api.actions.SwitchWorkspaceAction;
import com.codice.apiexamples.api.models.*;
import com.codice.apiexamples.example.utils.StdUtils;
import com.codice.apiexamples.example.utils.Utils;
import retrofit.RetrofitError;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * An example showing workspace creation and switch through the API.
 */
public class WorkspaceManagementExample {

    private static ApiService api;

    private static Workspace workspace;
    private static Repository repository;

    private static void createWorkspaceExample() throws RetrofitError {
        List<Repository> repositories = api.getAllRepositories();
        StdUtils.printRepositoryList(repositories);
        int repId = StdUtils.readIntegerFromConsole("Select a repository to be the source of a new workspace: ");
        repository = Utils.filterRepoById(repositories, repId);

        if (repository == null) {
            System.err.println("Invalid id.");
            System.exit(-1);
        }

        String workspacePath = StdUtils.readStringFromConsole("Write a complete path for the new workspace: ");

        CreateWorkspaceAction createParams = new CreateWorkspaceAction(
                repository.getName(), workspacePath, repository.getName());
        workspace = api.createWorkspace(createParams);
    }

    private static void switchWorkspaceExample() throws RetrofitError, InterruptedException {
        List<Branch> branches = api.getAllBranches(repository.getName());
        StdUtils.printBranchesList(branches);
        int branchId = StdUtils.readIntegerFromConsole("Select a branch to switch the workspace created to: ");
        Branch branch = Utils.filterBranchById(branches, branchId);

        if (branch == null) {
            System.err.println("Invalid id.");
            System.exit(-1);
        }

        SwitchWorkspaceAction switchParams = SwitchWorkspaceAction.buildSwitchToBranchAction(branch.getName());
        OperationStatus status = api.switchWorkspace(workspace.getName(), switchParams);

        while (!status.getStatus().equals("Finished")) {
            status = api.getSwitchStatus(workspace.getName());
            StdUtils.printSwitchMessage(status);
            Thread.sleep(1200);
        }
    }

    private static void addItemToWorkspaceExample() throws RetrofitError, IOException {
        String itemName = StdUtils.readStringFromConsole("Write a name for a new file: ");
        File file = new File(workspace.getPath(), itemName);

        if (!file.createNewFile()) {
            System.exit(-1);
        }

        AddItemAction addParams = new AddItemAction(false, false, false);
        api.addItemToWorkspace(workspace.getName(), itemName, addParams);

        String comment = StdUtils.readStringFromConsole("Write a comment for the checkin: ");
        CheckinAction checkinParams = new CheckinAction()
                .addPath(itemName)
                .setComment(comment);

        api.checkinPendingChanges(workspace.getName(), checkinParams);
    }

    public static void main(String[] args) {
        api = Utils.getApiInstance();

        try {
            createWorkspaceExample();
            switchWorkspaceExample();
            addItemToWorkspaceExample();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
