package com.codice.apiexamples.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * PlasticSCM's merge model.
 */
public class Merge {

    public enum MergeType {
        @SerializedName("None") NONE,
        @SerializedName("Copied") COPIED,
        @SerializedName("Replaced") REPLACED,
        @SerializedName("Merged") MERGED,
        @SerializedName("Moved") MOVED,
        @SerializedName("Deleted") DELETED,
        @SerializedName("Added") ADDED,
        @SerializedName("All") ALL
    }
    private MergeType mergeType;
    private Changeset sourceChangeset;

    public MergeType getMergeType() {
        return mergeType;
    }

    public Changeset getSourceChangeset() {
        return sourceChangeset;
    }
}
