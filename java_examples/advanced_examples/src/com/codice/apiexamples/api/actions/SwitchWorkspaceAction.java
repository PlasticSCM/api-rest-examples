package com.codice.apiexamples.api.actions;

import com.codice.apiexamples.api.models.Branch;
import com.codice.apiexamples.api.models.Changeset;
import com.codice.apiexamples.api.models.Label;
import com.sun.istack.internal.NotNull;

/**
 * Represents a 'Switch workspace to a different branch/label/changeset' action.
 */
public class SwitchWorkspaceAction {
    
    public static SwitchWorkspaceAction buildSwitchToBranchAction(
            @NotNull String branchName) {
        return new SwitchWorkspaceAction(ObjectType.BRANCH, branchName);
    }

    public static SwitchWorkspaceAction buildSwitchToLabelAction(
            @NotNull String labelName) {
        return new SwitchWorkspaceAction(ObjectType.LABEL, labelName);
    }

    public static SwitchWorkspaceAction buildSwitchToChangesetAction(
            @NotNull long changesetId) {
        return new SwitchWorkspaceAction(
            ObjectType.BRANCH, String.valueOf(changesetId));
    }
    
    private ObjectType objectType;
    private String object;

    /**
     *
     * @param objectType <b>Required.</b> the type of the switch destination.
     * @param object <b>Required.</b> The target point the workspace will be set to.
     *               {@link Changeset#getid()} {@link Label#getName()}
     *               {@link Branch#getName()}
     */
    private SwitchWorkspaceAction(
            @NotNull ObjectType objectType, @NotNull String object) {
        this.objectType = objectType;
        this.object = object;
    }

}
