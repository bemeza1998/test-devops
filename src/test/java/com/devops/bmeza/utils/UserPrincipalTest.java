package com.devops.bmeza.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@WebMvcTest(UserPrincipal.class)
public class UserPrincipalTest {

    private static final String USERNAME = "admin";
    private static final boolean ENABLED = true;
    private static final String PASSWORD = "randomPasswd";
    private static final String ROL = "admin";
    private Collection<? extends GrantedAuthority> authorities;

    @BeforeEach
    public void setup(){
        List<GrantedAuthority> rol = new ArrayList<GrantedAuthority>();
        rol.add(new SimpleGrantedAuthority(ROL));
        this.authorities = rol;
    }

    @Test
    public void createUserPrincipal_GetAndSet() throws Exception {

        UserPrincipal userPrincipal = new UserPrincipal(USERNAME, PASSWORD, ENABLED, authorities);

        assertNotNull(userPrincipal);
        assertEquals(userPrincipal.getUsername().getClass(), String.class);
        assertEquals(userPrincipal.getPassword().getClass(), String.class);
        assertEquals(userPrincipal.getAuthorities().getClass(), ArrayList.class);
        assertEquals(userPrincipal.isEnabled(), true);
        assertEquals(userPrincipal.isAccountNonExpired(), true);
        assertEquals(userPrincipal.isAccountNonLocked(), true);
        assertEquals(userPrincipal.isCredentialsNonExpired(), true);

    }
    
}
