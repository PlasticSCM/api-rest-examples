package com.codice.apiexamples.api.actions;

import com.sun.istack.internal.NotNull;

/**
 * Represents a 'rename' action
 */
public class RenameAction {

    private String name;

    /**
     *
     * @param name <b>Required</b> the new name of the object.
     */
    public RenameAction(@NotNull String name) {
        this.name = name;
    }
}
