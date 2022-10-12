package com.example.jwt.config.auth;

import com.example.jwt.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.awt.print.PrinterIOException;
import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {

    private final User user;

    public PrincipalDetails(User user){
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        user.getRoleList().forEach(r -> {
            authorities.add(()->{ return r;});
        });
        return authorities;
    }

}
