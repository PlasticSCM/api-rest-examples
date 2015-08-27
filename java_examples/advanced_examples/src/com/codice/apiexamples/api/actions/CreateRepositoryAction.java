package com.codice.apiexamples.api.actions;


import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * Represents a 'create a new repository' action.
 */
public class CreateRepositoryAction {

    private String name;
    private String server = "";

    /**
     *
     * @param name <b>Required</b> the name of the new repository.
     */
    public CreateRepositoryAction(@NotNull String name) {
        this.name = name;
    }

    /**
     *
     * @param name <b>Required</b> the name of the new repository.
     * @param server the target server where the repository should be created.
     *               If {@code null} or empty String, the repository will be created
     *               in the configured API server.
     */
    public CreateRepositoryAction(@NotNull String name, @Nullable String server) {
        this.name = name;
        if (server != null)
            this.server = server;
    }
}
