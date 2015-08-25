package com.codice.apiexamples.api.actions;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a 'undo pending changes in a workspace' action.
 */
public class UndoPendingChangesAction {

    private List<String> paths;

    public UndoPendingChangesAction() {
        paths = new ArrayList<>();
    }

    /**
     *
     * @param path The path of the file to be restored. It can be either
     *             a full path or a workspace-relative path.
     * @return a reference to {@code this} to allow method chaining.
     */
    public UndoPendingChangesAction addPath(@NotNull String path) {
        paths.add(path);
        return this;
    }
}
