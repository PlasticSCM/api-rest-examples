package com.codice.apiexamples.api.models;

import java.util.Date;

/**
 * PlasticSCM's changeset model.
 */
public class Changeset {

    private long id;
    private long parentId;
    private String comment;
    private Date creationDate;
    private String guid;
    private Branch branch;
    private Owner owner;
    private Repository repository;
    private String server;

    public long getid() {
        return id;
    }

    public String getServer() {
        return server;
    }

    public Repository getRepository() {
        return repository;
    }

    public Owner getOwner() {
        return owner;
    }

    public Branch getBranch() {
        return branch;
    }

    public String getGuid() {
        return guid;
    }

    /**
     *
     * @return the creation date in format yyyy-MM-dd'T'hh:mm:ss
     */
    public Date getCreationDate() {
        return creationDate;
    }

    public String getComment() {
        return comment;
    }

    public long getParentId() {
        return parentId;
    }
}
