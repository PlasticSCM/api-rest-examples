package com.codice.apiexamples.api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * PlasticSCM's changes in worskpace model.
 */
public class Change {

    public enum ChangeTypes {
        @SerializedName("added") ADDED,
        @SerializedName("checkout") CHECKED_OUT,
        @SerializedName("changed") CHANGED,
        @SerializedName("copied") COPIED,
        @SerializedName("replaced") REPLACED,
        @SerializedName("deleted") DELETED,
        @SerializedName("localdeleted") LOCALLY_DELETED,
        @SerializedName("moved") MOVED,
        @SerializedName("localmoved") LOCALLY_MOVED,
        @SerializedName("private") PRIVATE,
        @SerializedName("ignored") IGNORED,
        @SerializedName("hiddenchanged") HIDDEN_CHANGED,
        @SerializedName("controlledchanged") CONTROLLED_CHANGED,
        @SerializedName("all") ALL
    }

    private List<String> changes;
    private String path;
    private String oldPath;
    private String serverPath;
    private String oldServerPath;
    private boolean isXLink;
    private LocalInfo localInfo;
    private RevisionInfo revisionInfo;

    // Pending of revision
    private List<String> getChanges() {
        return changes;
    }

    public String getPath() {
        return path;
    }

    public String getOldPath() {
        return oldPath;
    }

    public String getServerPath() {
        return serverPath;
    }

    public String getOldServerPath() {
        return oldServerPath;
    }

    public boolean isXLink() {
        return isXLink;
    }

    public LocalInfo getLocalInfo() {
        return localInfo;
    }

    public RevisionInfo getRevisionInfo() {
        return revisionInfo;
    }
}
