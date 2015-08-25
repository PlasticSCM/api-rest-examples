package com.codice.apiexamples.api.actions;

import com.google.gson.annotations.SerializedName;

public enum ObjectType {
    @SerializedName("changeset") CHANGESET,
    @SerializedName("label") LABEL,
    @SerializedName("branch")BRANCH
}
