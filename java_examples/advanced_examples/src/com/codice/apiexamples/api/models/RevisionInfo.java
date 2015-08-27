package com.codice.apiexamples.api.models;

import java.util.Date;

/**
 * PlasticSCM's revision info model.
 */
public class RevisionInfo {

    private long id;
    private long parentId;
    private long itemId;
    private String type;
    private long size;
    private String hash;
    private long branchid;
    private long changesetId;
    private boolean isCheckedOut;
    private Date creationDate;
    private RepId repositoryId;
    private Owner owner;

    public long getId() {
        return id;
    }

    public long getParentId() {
        return parentId;
    }

    public long getItemId() {
        return itemId;
    }

    public String getType() {
        return type;
    }

    public long getSize() {
        return size;
    }

    public String getHash() {
        return hash;
    }

    public long getBranchid() {
        return branchid;
    }

    public long getChangesetId() {
        return changesetId;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public RepId getRepositoryId() {
        return repositoryId;
    }

    public Owner getOwner() {
        return owner;
    }
}
