package com.codice.apiexamples.api.models;

import com.google.gson.annotations.SerializedName;
import com.sun.istack.internal.Nullable;

import java.util.Date;
import java.util.List;

/**
 * PlasticSCM's diff model.
 */
public class Diff {

    public enum Status {
        @SerializedName("Added") ADDED,
        @SerializedName("Deleted") DELETED,
        @SerializedName("Moved") MOVED,
        @SerializedName("Changed") CHANGED
    }

    private Status status;
    private String path;
    private String srcPath;
    private long revisionId;
    private long srcRevisionId;
    private boolean isDirectory;
    private long size;
    private String hash;
    private String srcHash;
    private boolean isUnderXlink;
    private XLink xlink;
    private XLink baseXlink;
    private List<Merge> merges;
    private boolean isItemFSProtectionChanged;
    // TODO change this to enum if possible
    private String itemFileSystemProtection;
    private Repository repository;
    private Date modifiedTime;
    private Owner createdBy;

    public Status getStatus() {
        return status;
    }

    public String getPath() {
        return path;
    }

    public String getSrcPath() {
        return srcPath;
    }

    public long getRevisionId() {
        return revisionId;
    }

    public long getSrcRevisionId() {
        return srcRevisionId;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public long getSize() {
        return size;
    }

    @Nullable
    public String getHash() {
        return hash;
    }

    @Nullable
    public String getSrcHash() {
        return srcHash;
    }

    public boolean isUnderXlink() {
        return isUnderXlink;
    }

    @Nullable
    public XLink getXlink() {
        return xlink;
    }

    @Nullable
    public XLink getBaseXlink() {
        return baseXlink;
    }

    @Nullable
    public List<Merge> getMerges() {
        return merges;
    }

    public boolean isItemFSProtectionChanged() {
        return isItemFSProtectionChanged;
    }

    public String getItemFileSystemProtection() {
        return itemFileSystemProtection;
    }

    public Repository getRepository() {
        return repository;
    }

    @Nullable
    public Date getModifiedTime() {
        return modifiedTime;
    }

    @Nullable
    public Owner getCreatedBy() {
        return createdBy;
    }
}
