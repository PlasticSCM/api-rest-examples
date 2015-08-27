package com.codice.apiexamples.api.actions;

import com.sun.istack.internal.NotNull;

/**
 * Represents a 'create a new workspace' action.
 */
public class CreateWorkspaceAction {

    private String path;
    private String name;
    private String repository;

    /**
     * Action that creates a new workspace using the last repository created as source.
     *
     * @param name <b>Required</b> The name of the new workspace.
     * @param path <b>Required</b> The target path where the repository should be created.
     */
    public CreateWorkspaceAction(@NotNull String name, @NotNull String path) {
        this.name = name;
        this.path = path;
    }

    /**
     * Action that creates a new workspace with the provided information.
     *
     * @param name <b>Required</b> The name of the new workspace.
     * @param path <b>Required</b> The target path where the repository should be created.
     * @param repository The source repository for the new workspace.
     */
    public CreateWorkspaceAction(
            @NotNull String name, @NotNull String path, @NotNull String repository) {
        this.name = name;
        this.path = path;
        this.repository = repository;
    }
}
