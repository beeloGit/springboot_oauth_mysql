package com.oauth2.oaut2demo.Wrappers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oauth2.oaut2demo.Modals.Permission;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PermissionWrapper {
    long id;
    String name;
    String description;
    boolean deleted;
    boolean active;

    public PermissionWrapper() {
    }

    public PermissionWrapper(Permission permission) {
        this.id = permission.getId();
        this.name = permission.getName();
        this.description = permission.getDescription();
        this.deleted = permission.isDeleted();
        this.active = permission.isActive();

    }

    public PermissionWrapper(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public PermissionWrapper(long id, String name, String description, boolean deleted, boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deleted = deleted;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
