package com.codice.apiexamples.api.actions;

import com.codice.apiexamples.api.models.Changeset;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * Represents a 'create label' action.
 */
public class CreateLabelAction {

    private String name;
    private long changeset;
    private String comment = "";
    private boolean applyToXlinks = false;

    /**
     *
     * @param name <b>Required.</b> The name of the label.
     * @param changeset <b>Required.</b> The changeset to label. {@link Changeset#getid()}
     * @param comment The comment to add to the label. It can be either
     *                null or an empty String.
     */
    public CreateLabelAction(
            @NotNull String name,
            @NotNull long changeset,
            @Nullable String comment) {
        this.name = name;
        this.changeset = changeset;
        if (comment != null)
            this.comment = comment;
    }

    /**
     *
     * @param name <b>Required.</b> The name of the label.
     * @param changeset <b>Required.</b> The changeset to label.
     *                  {@link Changeset#getid()}
     * @param comment The comment to add to the label. It can be either
     *                null or an empty String.
     * @param applyToXlinks {@code true} to label all the xlinked changesets linked at
     *                      the specified changeset. {@code false} by default.
     */
    public CreateLabelAction(@NotNull String name, long changeset,
                             @Nullable String comment, boolean applyToXlinks) {
        this.name = name;
        this.changeset = changeset;
        this.applyToXlinks = applyToXlinks;
        if (comment != null)
            this.comment = comment;
    }
}
