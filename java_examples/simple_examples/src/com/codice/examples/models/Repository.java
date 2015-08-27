package com.codice.examples.models;


import java.util.UUID;

public class Repository {

    private RepId repId;
    private Owner owner;
    private String name;
    private UUID guid;
    private String server;

    public RepId getRepId() { return repId; }
    public Owner getOwner() { return owner; }
    public String getName() { return name; }
    public UUID getGuid() { return guid; }
    public String getServer() { return server; }
}
