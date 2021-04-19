package com.oauth2.oaut2demo.Wrappers;

import com.oauth2.oaut2demo.Modals.Role;

import java.util.List;


public class RoleWrapper {

    long id;
    String name;
    String description;
    boolean deleted;
    boolean active;
    List<PermissionWrapper> permissions;

    public RoleWrapper() {
    }

    public RoleWrapper(Role role) {
        this.id = role.getId();
        this.name = role.getName();
        this.description = role.getDescription();
        this.deleted = role.isDeleted();
        this.active = role.isActive();
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

    public List<PermissionWrapper> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionWrapper> permissions) {
        this.permissions = permissions;
    }
}
