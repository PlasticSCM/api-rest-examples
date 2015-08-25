package com.codice.apiexamples.api.actions;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the 'check in pending changes' action.
 */
public class CheckinAction {

    private List<String> paths;
    private String comment;
    private boolean recurse;

    /**
     * Creates an empty Checkin action. If an empty action is sent to the API, the checkin path will be the root
     * of the workspace {@see #addPath}, the comment will be empty {@see #setComment} and it won't be a recursive
     * checkin {@see #setRecursive}.
     */
    public  CheckinAction() {
        paths = new ArrayList<>();
        comment = "";
        recurse = false;
    }

    /**
     *
     * @param path a path to be checked in.
     * @return a reference to {@code this} to allow method chaining.
     */
    public CheckinAction addPath(@NotNull String path) {
        paths.add(path);
        return this;
    }

    /**
     *
     * @param comment the checkin comment. By default it is an empty String.
     * @return a reference to {@code this} to allow method chaining.
     */
    public CheckinAction setComment(@NotNull String comment) {
        this.comment = comment;
        return this;
    }

    /**
     *
     * @param recurse {@code true} if you want to add recursively to the checkin all the children directories of
     *                              the directory set with {@link #addPath(String)}.
     * @return a reference to {@code this} to allow method chaining.
     */
    public CheckinAction setRecursive(boolean recurse) {
        this.recurse = recurse;
        return this;
    }
}
