package com.codice.apiexamples.api.models;

import java.util.Date;

/**
 * PlasticSCM's label model.
 */
public class Label {

    private String name;
    private long id;
    private long changeset;
    private String comment;
    private Date creationDate;
    private Branch branch;
    private Owner owner;
    private Repository repository;
    private String server;

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public long getChangeset() {
        return changeset;
    }

    public String getComment() {
        return comment;
    }

    /**
     *
     * @return the creation date in format yyyy-MM-dd'T'hh:mm:ss
     */
    public Date getCreationDate() {
        return creationDate;
    }

    public Branch getBranch() {
        return branch;
    }

    public Owner getOwner() {
        return owner;
    }

    public Repository getRepository() {
        return repository;
    }

    public String getServer() {
        return server;
    }
}
