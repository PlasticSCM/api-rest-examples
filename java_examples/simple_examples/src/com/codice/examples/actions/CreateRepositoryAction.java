package com.codice.examples.actions;


import com.sun.istack.internal.NotNull;

public class CreateRepositoryAction {

    private String name;
    private String server;

    public CreateRepositoryAction(@NotNull String name,
                                  @NotNull String server) {
        this.name = name;
        this.server = server;
    }
}
