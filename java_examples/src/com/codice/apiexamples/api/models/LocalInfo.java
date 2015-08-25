package com.codice.apiexamples.api.models;

/**
 * PlasticSCM's local info model.
 */
public class LocalInfo {

    private String modifiedTime;
    private long size;
    private boolean isMissing;

    /**
     *
     * @return the modification date in format yyyy-MM-dd'T'hh:mm:ss.ffffffZ
     */
    public String getModifiedTime() {
        return modifiedTime;
    }

    public long getSize() {
        return size;
    }

    public boolean isMissing() {
        return isMissing;
    }
}
