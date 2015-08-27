package com.codice.apiexamples.api.models;

/**
 * PlasticSCM's checkin status model.
 */
public class CheckinStatus {

    private String status;
    private String message;
    private long totalSize;
    private long transferredSize;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public long getTotalSize() {
        return totalSize;
    }

    public long getTransferredSize() {
        return transferredSize;
    }
}
