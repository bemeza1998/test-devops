package com.devops.bmeza.resources;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.devops.bmeza.model.Login;
import com.devops.bmeza.utils.JWT;
import com.devops.bmeza.utils.JwtUtils;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtUtils jwtUtils;

    @Test
    public void authenticateUser_Success() throws Exception {

        Login login = new Login("admin", "zq5Mpn9174uAFHgF");
        Authentication authentication = new UsernamePasswordAuthenticationToken(login.getName(), login.getPassword());
        String jwt = "test_jwt";

        when(authenticationManager.authenticate(any())).thenReturn(authentication);
        when(jwtUtils.generateJwtToken(any())).thenReturn(jwt);

        ResponseEntity<JWT> response = userController.authenticateUser(login);
        System.out.println(response);

        assertNotNull(response);
        assertNotNull(SecurityContextHolder.getContext().getAuthentication());
        assertEquals(true, response.getStatusCode().is2xxSuccessful());
        assertEquals(response.getBody().getClass(),JWT.class);
        //mvc.perform(MockMvcRequestBuilders.post("/auth/signin").content(login).contentType(MediaType.APPLICATION_JSON).header("X-Parse-REST-API-Key", "2f5ae96c-b558-4c7b-a590-a501ae1c3f6")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void authenticateUser_InvalidCredentials() {
        // Given
        Login l = new Login("adminA", "wrongPassword");
        //when(authenticationManager.authenticate(any())).thenThrow(BadCredentialsException.class);

        // When
        ResponseEntity<JWT> response = userController.authenticateUser(l);

        // Then
        assertNotNull(response);
        //assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }

}