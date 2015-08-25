package com.codice.apiexamples.api.actions;

import com.sun.istack.internal.NotNull;

/**
 * Represents a 'create a new repository' action.
 */
public class CreateBranchAction {

    private String name;
    private ObjectType originType;
    private String origin;
    private boolean topLevel;

    /**
     * @param name       <b>Required.</b> The branch name. Do NOT use hierarchy here.
     * @param originType <b>Required.</b> The type of source to retrieve the parent changeset of the new branch.
     * @param origin     <b>Required.</b> The point of origin from which the branch will be created.
     * @param topLevel Whether or not the branch will be top-level (without a parent).
     */
    private CreateBranchAction(
            @NotNull String name,
            @NotNull ObjectType originType,
            @NotNull String origin,
            boolean topLevel) {
        this.name = name;
        this.originType = originType;
        this.origin = origin;
        this.topLevel = topLevel;
    }

    public static CreateBranchAction buildCreateBranchFromBranchAction(
            @NotNull String newName, @NotNull String originName) {
        return new CreateBranchAction(
                newName, ObjectType.BRANCH, originName, false);
    }

    public static CreateBranchAction buildCreateBranchFromLabelAction(
            @NotNull String newName, @NotNull String labelName) {
        return new CreateBranchAction(
                newName, ObjectType.LABEL, labelName, false);
    }

    public static CreateBranchAction buildCreateBranchFromchangesetAction(
            @NotNull String newName, @NotNull int changesetId) {
        return new CreateBranchAction(
                newName, ObjectType.CHANGESET, String.valueOf(changesetId), false);
    }


}

