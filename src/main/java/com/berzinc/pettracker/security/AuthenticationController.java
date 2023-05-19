package com.berzinc.pettracker.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.berzinc.pettracker.users.User;

import java.net.URI;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    
    @Autowired
    private AuthenticationService authenticationService;

    @CrossOrigin
    @PostMapping(
        path = "/signin",
        produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            AuthenticationResponse authenticationResponse = authenticationService.authenticateUser(authenticationRequest);
            return ResponseEntity.ok(authenticationResponse);
        } catch(Exception e) {
			return ResponseEntity
					.badRequest()
					.body(e.getMessage());
        }

    }

    @CrossOrigin
    @PostMapping(
        path = "/signup",
        produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        try {

            User user = authenticationService.registerNewUser(registerUserRequest);

            URI uri = URI.create("/api/users/" + user.getUsername());
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.setLocation(uri);

            return new ResponseEntity<Object>(user, responseHeaders, HttpStatus.CREATED);
        } catch(Exception e) {
			return ResponseEntity
					.badRequest()
					.body("Error: Username is already taken! " + e.getMessage());
        }
    }

    @CrossOrigin
    @PostMapping(
        path = "/refresh",
        produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        try {
            AuthenticationResponse authenticationResponse = authenticationService.refreshToken(refreshTokenRequest);
            return ResponseEntity.ok(authenticationResponse);
        } catch(IllegalArgumentException | IllegalStateException e) {
			return ResponseEntity
					.badRequest()
					.body(e.getMessage());
        }
    }

}
