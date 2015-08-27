package com.codice.apiexamples.api.models;

import java.util.Date;
import java.util.UUID;


/**
 * PlasticSCM's branch model.
 */
public class Branch {

    private String name;
    private long id;
    private long parentId;
    private long lastChangeset;
    private String comment;
    private Date creationDate;
    private UUID guid;
    private Owner owner;
    private Repository repository;

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public long getParentId() {
        return parentId;
    }

    public long getLastChangeset() {
        return lastChangeset;
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

    public UUID getGuid() {
        return guid;
    }

    public Owner getOwner() {
        return owner;
    }

    public Repository getRepository() {
        return repository;
    }
}
