package com.codice.apiexamples.api.actions;

/**
 * Represents the 'add item to version control' action.
 */
public class AddItemAction {

    private boolean addPrivateParents;
    private boolean checkOutParent;
    private boolean recurse;

    /**
     *
     * @param addPrivateParents {@code true} to add parent directories not under version control yet.
     * @param checkOutParent {@code true} to check-out the parent item.
     * @param recurse {@code true} to add recursively all children items.
     */
    public AddItemAction(boolean addPrivateParents, boolean checkOutParent, boolean recurse) {
        this.addPrivateParents = addPrivateParents;
        this.checkOutParent = checkOutParent;
        this.recurse = recurse;
    }
}
