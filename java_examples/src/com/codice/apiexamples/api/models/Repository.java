package com.codice.apiexamples.api.models;

import com.sun.istack.internal.Nullable;

import java.util.UUID;


/**
 * PlasticSCM's repository model.
 */
public class Repository {

    private RepId repId;
    private Owner owner;
    private String name;
    private UUID guid;
    private String server;

    @Nullable
    public RepId getRepid() {
        return repId;
    }

    @Nullable
    public Owner getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    @Nullable
    public UUID getGuid() {
        return guid;
    }

    public String getServer() {
        return server;
    }

    public String getCompleteName() {
        return getName() + "@" + getServer();
    }
}
