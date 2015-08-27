package com.codice.apiexamples.api.models;

/**
 * PlasticSCM's status model.
 */
public class OperationStatus {

    private String status = "";
    private String message = "";
    private long totalFiles;
    private long totalBytes;
    private long updatedFiles;
    private long updatedBytes;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public long getTotalFiles() {
        return totalFiles;
    }

    public long getTotalBytes() {
        return totalBytes;
    }

    public long getUpdatedFiles() {
        return updatedFiles;
    }

    public long getUpdatedBytes() {
        return updatedBytes;
    }
}
