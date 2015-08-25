package com.codice.apiexamples.api.models;

/**
 * PlasticSCM's XLink target model.
 */
public class XLink {

    private String changesetGuid;
    private long changesetId;
    private String repository;
    private String server;

    public String getChangesetGuid() {
        return changesetGuid;
    }

    public long getChangesetId() {
        return changesetId;
    }

    public String getRepository() {
        return repository;
    }

    public String getServer() {
        return server;
    }
}
