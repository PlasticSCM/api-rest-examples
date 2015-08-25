package com.codice.apiexamples.api.models;

import com.google.gson.annotations.SerializedName;
import com.sun.istack.internal.Nullable;

import java.util.List;

/**
 * PlasticSCM's item model.
 */
public class Item {

    public enum ItemType {
        @SerializedName("file") FILE,
        @SerializedName("directory") DIRECTORY
    }

    private ItemType type;
    private long size;
    private String name;
    private String path;
    private boolean isUnderXlink;
    private String hash;
    private String content;
    private String server;
    private XLink xlinkTarget;
    private List<Item> items;

    public ItemType getType() {
        return type;
    }

    public long getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public boolean isUnderXlink() {
        return isUnderXlink;
    }

    @Nullable
    public String getContent() {
        return content;
    }

    @Nullable
    public String getHash() {
        return hash;
    }

    @Nullable
    public String getServer() {
        return server;
    }

    @Nullable
    public XLink getXlinkTarget() {
        return xlinkTarget;
    }

    @Nullable
    public List<Item> getItems() {
        return items;
    }
}
