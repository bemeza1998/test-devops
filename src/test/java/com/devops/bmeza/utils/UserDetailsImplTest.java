package com.devops.bmeza.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@WebMvcTest(UserDetailsImpl.class)
public class UserDetailsImplTest {

    private static final String ID = "admin";
    private static final String NAME = "randomPasswd";
    private static final String PASSWORD = "admin";
    private static final String ROL = "admin";
    private GrantedAuthority authoritie;

    @BeforeEach
    public void setup(){
        this.authoritie = new SimpleGrantedAuthority(ROL);
    }

    @Test
    public void createUserPrincipalImpl_GetAndSet() throws Exception {

        UserDetailsImpl userDetailsImpl = new UserDetailsImpl(ID,NAME,PASSWORD,authoritie);

        assertNotNull(userDetailsImpl);
        assertEquals(userDetailsImpl.getId().getClass(), String.class);
        assertEquals(userDetailsImpl.getUsername().getClass(), String.class);
        assertEquals(userDetailsImpl.getPassword().getClass(), String.class);
        assertEquals(userDetailsImpl.getAuthorities().getClass(), ArrayList.class);
        assertEquals(userDetailsImpl.isEnabled(), true);
        assertEquals(userDetailsImpl.isAccountNonExpired(), true);
        assertEquals(userDetailsImpl.isAccountNonLocked(), true);
        assertEquals(userDetailsImpl.isCredentialsNonExpired(), true);
        assertEquals(userDetailsImpl.equals(userDetailsImpl), true);


    }
    
}
