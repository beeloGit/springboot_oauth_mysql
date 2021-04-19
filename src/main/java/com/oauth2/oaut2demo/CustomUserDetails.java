package com.oauth2.oaut2demo;

import com.oauth2.oaut2demo.Modals.Role;
import com.oauth2.oaut2demo.Modals.User;
import com.oauth2.oaut2demo.Modals.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private String userName;
    private String password;
    Collection<? extends GrantedAuthority> authorities;
    public CustomUserDetails(User byUserNameAndPassword) {
        this.userName = byUserNameAndPassword.getUsername();
        this.password = byUserNameAndPassword.getPassword();
        List<GrantedAuthority> auths = new ArrayList<>();
        for(UserRole role : byUserNameAndPassword.getRoles()) {
            auths.add(new SimpleGrantedAuthority(role.getUser().getUsername()));
        }
        this.authorities = auths;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
