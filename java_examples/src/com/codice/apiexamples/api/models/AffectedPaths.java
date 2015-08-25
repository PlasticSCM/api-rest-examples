package com.codice.apiexamples.api.models;

import java.util.List;

/**
 * PlasticSCM's affected paths model. Represents the paths that were affected by a undo operation.
 */
public class AffectedPaths {

    private List<String> paths;

    public List<String> getPaths() {
        return paths;
    }
}
