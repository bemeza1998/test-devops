package com.devops.bmeza.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devops.bmeza.model.Login;
import com.devops.bmeza.utils.JWT;
import com.devops.bmeza.utils.JwtUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<JWT> authenticateUser(@RequestBody Login login) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login.getName(), login.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        return ResponseEntity.ok(new JWT(jwt));
    }

}
