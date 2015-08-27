package com.codice.apiexamples.api.models;

import java.util.UUID;

/**
 * PlasticSCM's workspace model.
 */
public class Workspace {

    private String name;
    private UUID guid;
    private String path;
    private String machineName;

    public String getName() {
        return name;
    }

    public UUID getGuid() {
        return guid;
    }

    public String getPath() {
        return path;
    }

    public String getMachine() {
        return machineName;
    }
}
