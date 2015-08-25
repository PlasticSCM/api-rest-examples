package com.codice.apiexamples.api;

import com.codice.apiexamples.api.actions.*;
import com.codice.apiexamples.api.models.*;
import retrofit.Callback;
import retrofit.http.*;

import java.util.List;

/**
 * API Interface.
 */
public interface ApiService {

    @GET("/api/v1/repos")
    List<Repository> getAllRepositories();

    @GET("/api/v1/repos")
    void getAllRepositories(Callback<List<Repository>> callback);

    @GET("/api/v1/repos/{repname}")
    Repository getSingleRepository(@Path("repname") String repName);

    @GET("/api/v1/repos/{repname}")
    void getSingleRepository(
            @Path("repname") String repName, Callback<Repository> callback);

    @POST("/api/v1/repos")
    Repository createRepository(@Body CreateRepositoryAction params);

    @POST("/api/v1/repos")
    void createRepository(
            @Body CreateRepositoryAction params, Callback<Repository> callback);

    @PUT("/api/v1/repos/{repname}")
    Repository renameRepository(
            @Path("repname") String oldName, @Body RenameAction params);

    @PUT("/api/v1/repos/{repname}")
    void renameRepository(
            @Path("repname") String oldName,
            @Body RenameAction params,
            Callback<Repository> callback);

    @GET("/api/v1/wkspaces")
    List<Workspace> getAllWorkspaces();

    @GET("/api/v1/wkspaces")
    void getAllWorkspaces(Callback<List<Workspace>> callback);

    @GET("/api/v1/wkspaces/{wkspacename}")
    Workspace getSingleWorkspace(@Path("wkspacename") String wkspaceName);

    @GET("/api/v1/wkspaces/{wkspacename}")
    void getSingleWorkspace(
            @Path("wkspacename") String wkspaceName,
            Callback<Workspace> callback);

    @POST("/api/v1/wkspaces")
    Workspace createWorkspace(@Body CreateWorkspaceAction params);

    @POST("/api/v1/wkspaces")
    void createWorkspace(
            @Body CreateWorkspaceAction params,
            Callback<Workspace> callback);

    @PUT("/api/v1/wkspaces/{wkspacename}")
    Repository renameWorkspace(
            @Path("wkspacename") String wkspaceName,
            @Body RenameAction params);

    @PUT("/api/v1/wkspaces/{wkspacename}")
    void renameWorkspace(
            @Path("wkspacename") String wkspaceName,
            @Body RenameAction params,
            Callback<Workspace> callback);

    @DELETE("/api/v1/wkspaces/{wkspacename}")
    void deleteWorskpace(@Path("wkspacename") String wkspaceName);

    @GET("/api/v1/repos/{repname}/branches")
    List<Branch> getAllBranches(@Path("repname") String repositoryName);

    @GET("/api/v1/repos/{repname}/branches")
    void getAllBranches(
            @Path("repname") String repositoryName, Callback<List<Branch>> callback);

    @GET("/api/v1/repos/{repname}/branches/{branchname}")
    Branch getSingleBranch(
            @Path("repname") String repositoryName,
            @Path("branchname") String branchName);

    @GET("/api/v1/repos/{repname}/branches/{branchname}")
    void getSingleBranch(
            @Path("repname") String repositoryName,
            @Path("branchname") String branchName,
            Callback<Branch> callback);

    @POST("/api/v1/repos/{repname}/branches")
    Branch createBranch(
            @Path("repname") String repositoryName,
            @Body CreateBranchAction params);

    @POST("/api/v1/repos/{repname}/branches")
    void createBranch(
            @Path("repname") String repositoryName,
            @Body CreateBranchAction params,
            Callback<Branch> callback);

    @PATCH("/api/v1/repos/{repname}/branches/{branchname}")
    Branch renameBranch(
            @Path("repname") String repositoryName,
            @Path("branchname") String branchName,
            @Body RenameAction params);

    @PATCH("/api/v1/repos/{repname}/branches/{branchname}")
    void renameBranch(
            @Path("repname") String repositoryname,
            @Path("branchname") String branchName,
            @Body RenameAction params,
            Callback<Branch> callback);

    @DELETE("/api/v1/repos/{repname}/branches/{branchname}")
    void deleteBranch(
            @Path("repname") String repositoryName,
            @Path("branchname") String branchName);

    @GET("/api/v1/repos/{repname}/labels")
    List<Label> getAllLabels(@Path("repname") String repositoryName);

    @GET("/api/v1/repos/{repname}/labels")
    void getAllLabels(
            @Path("repname") String repositoryName,
            Callback<List<Label>> callback);

    @GET("/api/v1/repos/{repname}/labels/{lbname}")
    Label getSingleLabel(
            @Path("repname") String repositoryName,
            @Path("lbname") String labelName);

    @GET("/api/v1/repos/{repname}/labels/{lbname}")
    void getSingleLabel(
            @Path("repname") String repositoryName,
            @Path("lbname") String labelName,
            Callback<Label> callback);

    @POST("/api/v1/repos/{repname}/labels")
    Label createLabel(
            @Path("repname") String repositoryName,
            @Body CreateLabelAction params);

    @POST("/api/v1/repos/{repname}/labels")
    void createLabel(
            @Path("repname") String repositoryName,
            @Body CreateLabelAction params,
            Callback<Label> callback);

    @PATCH("/api/v1/repos/{repname}/labels/{lbname}")
    Label renameLabel(
            @Path("repname") String repositoryName,
            @Path("lbname") String labelName,
            @Body RenameAction params);

    @PATCH("/api/v1/repos/{repname}/labels/{lbname}")
    void renameLabel(
            @Path("repname") String repositoryName,
            @Path("lbname") String labelName,
            @Body RenameAction params,
            Callback<Label> callback);

    @DELETE("/api/v1/repos/{repname}/labels/{lbname}")
    void deleteLabel(
            @Path("repname") String repositoryName,
            @Path("lbname") String labelName);

    @GET("/api/v1/repos/{repname}/changesets")
    List<Changeset> getAllChangesets(
            @Path("repname") String repositoryName);

    @GET("/api/v1/repos/{repname}/changesets")
    List<Changeset> getChangesetsByQuery(
            @Path("repname") String repositoryName, @Query("q") String query);

    @GET("/api/v1/repos/{repname}/changesets")
    void getAllChangesets(
            @Path("repname") String repositoryName,
            Callback<List<Changeset>> callback);

    @GET("/api/v1/repos/{repname}/changesets")
    void getChangesetsByQuery(
            @Path("repname") String repositoryName,
            @Query("q") String query,
            Callback<List<Changeset>> callback);

    @GET("/api/v1/repos/{repname}/branches/{branchname}/changesets")
    List<Changeset> getAllChangesetsInBranch(
            @Path("repname") String repositoryName,
            @Path("branchname") String branchName);

    @GET("/api/v1/repos/{repname}/branches/{branchname}/changesets")
    List<Changeset> getChangesetsInBranchByQuery(
            @Path("repname") String repositoryName,
            @Path("branchname") String branchName,
            @Query("q") String query);

    @GET("/api/v1/repos/{repname}/branches/{branchname}/changesets")
    void getAllChangesetsInBranch(
            @Path("repname") String repositoryName,
            @Path("branchname") String branchName,
            Callback<List<Changeset>> callback);

    @GET("/api/v1/repos/{repname}/branches/{branchname}/changesets")
    void getChangesetsInBranchByQuery(
            @Path("repname") String repositoryName,
            @Path("branchname") String branchName,
            @Query("q") String query,
            Callback<List<Changeset>> callback);

    @GET("/api/v1/repos/{repname}/changesets/{csid}")
    Changeset getSingleChangeset(
            @Path("repname") String repositoryName, @Path("csid") int changesetId);

    @GET("/api/v1/repos/{repname}/changesets/{csid}")
    void getSingleChangeset(
            @Path("repname") String repositoryName,
            @Path("csid") int changesetId,
            Callback<Changeset> callback);

    @GET("/api/v1/wkspaces/{wkname}/changes")
    List<Change> getPendingChangesInWorkspace(@Path("wkname") String wkspaceName);

    @GET("/api/v1/wkspaces/{wkname}/changes")
    void getPendingChangesInWorkspace(
            @Path("wkname") String wkspaceName, Callback<List<Change>> callback);

    @DELETE("/api/v1/wkspaces/{wkname}/changes")
    void undoPendingChangesInWorkspace(
            @Path("wkname") String wkspaceName, @Body UndoPendingChangesAction params);

    @POST("/api/v1/wkspaces/{wkname}/update")
    OperationStatus updateWorkspace(@Path("wkname") String wkspaceName);

    @POST("/api/v1/wkspaces/{wkname}/update")
    void updateWorkspace(@Path("wkname") String wkspaceName, Callback<OperationStatus> callback);

    @GET("/api/v1/wkspaces/{wkname}/update")
    OperationStatus getUpdateStatus(@Path("wkname") String wkspaceName);

    @GET("/api/v1/wkspaces/{wkname}/update")
    void getUpdateStatus(
            @Path("wkname") String wkspaceName, Callback<OperationStatus> callback);

    @GET("/api/v1/wkspaces/{wkname}/switch")
    OperationStatus getSwitchStatus(@Path("wkname") String wkspaceName);

    @GET("/api/v1/wkspaces/{wkname}/switch")
    void getSwitchStatus(
            @Path("wkname") String wkspaceName, Callback<OperationStatus> callback);

    @POST("/api/v1/wkspaces/{wkname}/switch")
    OperationStatus switchWorkspace(
            @Path("wkname") String wkspaceName, @Body SwitchWorkspaceAction params);

    @POST("/api/v1/wkspaces/{wkname}/switch")
    void switchWorkspace(
            @Path("wkname") String wkspaceName,
            @Body SwitchWorkspaceAction params,
            Callback<OperationStatus> callback);

    @POST("/api/v1/wkspaces/{wkname}/checkin")
    CheckinStatus checkinPendingChanges(
            @Path("wkname") String wkspaceName, @Body CheckinAction params);

    @POST("/api/v1/wkspaces/{wkname}/checkin")
    void checkinPendingChanges(
            @Path("wkname") String wkspaceName,
            @Body CheckinAction params,
            Callback<CheckinStatus> callback);

    @GET("/api/v1/wkspaces/{wkname}/checkin")
    OperationStatus getCheckinStatus(@Path("wkname") String wkspaceName);

    @GET("/api/v1/wkspaces/{wkname}/checkin")
    void getCheckinStatus(@Path("wkname") String wkspaceName, Callback<OperationStatus> callback);

    @GET("/api/v1/repos/{repname}/contents/{path}")
    Item getItemInRepository(
            @Path("repname") String repositoryName, @Path("path") String itemPath);

    @GET("/api/v1/repos/{repname}/contents/{path}")
    void getItemInRepository(
            @Path("repname") String repositoryName,
            @Path("path") String itemPath,
            Callback<Item> callback);

    @GET("/api/v1/repos/{repname}/branches/{brname}/contents/{path}")
    Item getItemInBranch(
            @Path("repname") String repositoryName,
            @Path("brname") String branchName,
            @Path("path") String itemPath);

    @GET("/api/v1/repos/{repname}/branches/{brname}/contents/{path}")
    void getItemInBranch(
            @Path("repname") String repositoryName,
            @Path("brname") String branchName,
            @Path("path") String itemPath,
            Callback<Item> callback);

    @GET("/api/v1/repos/{repname}/changesets/{csid}/diff")
    Diff diffChangesetWithItsParent(
            @Path("repname") String repositoryName,
            @Path("csid") int changesetId);

    @GET("/api/v1/repos/{repname}/changesets/{csid}/diff")
    void diffChangesetWithItsParent(
            @Path("repname") String repositoryName,
            @Path("csid") int changesetId,
            Callback<Diff> callback);

    @GET("/api/v1/repos/{repname}/changesets/{csid}/diff{sourcecsid}")
    Diff diffChangests(
            @Path("repname") String repositoryName,
            @Path("csid") int changesetId,
            @Path("sourcecsid") int sourceChangesetId);

    @GET("/api/v1/repos/{repname}/changesets/{csid}/diff{sourcecsid}")
    void diffChangests(
            @Path("repname") String repositoryName,
            @Path("csid") int changesetId,
            @Path("sourcecsid") int sourceChangesetId,
            Callback<Diff> callback);

    @POST("/api/v1/wkspaces/{wkname}/content/{path}")
    AffectedPaths addItemToWorkspace(
            @Path("wkname") String wkspaceName,
            @Path("path") String itemPath,
            @Body AddItemAction params);

    @POST("/api/v1/wkspaces/{wkname}/content/{path}")
    void addItemToWorkspace(
            @Path("wkname") String wkspaceName,
            @Path("path") String itemPath,
            @Body AddItemAction params,
            Callback<AffectedPaths> callback);

    @PUT("/api/v1/wkspaces/{wkname}/content/{path}")
    AffectedPaths checkOutWorkspaceItem(
            @Path("wkname") String wkspaceName, @Path("path") String itemPath);

    @PUT("/api/v1/wkspaces/{wkname}/content/{path}")
    void checkOutWorkspaceItem(
            @Path("wkname") String wkspaceName,
            @Path("path") String itemPath,
            Callback<AffectedPaths> callback);
}
