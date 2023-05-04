package com.berzinc.pettracker.security;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CredentialsTest {

    @Test
    void getPassword_returnsPassword() {
        String expectedPassword = "some_password";
        Credentials credentials = new Credentials("some_username", expectedPassword);
        assertEquals(expectedPassword, credentials.getPassword());
    }

    @Test
    void getUsername_returnsUsername() {
        String expectedUsername = "some_userName";
        Credentials credentials = new Credentials(expectedUsername, "some_password");
        assertEquals(expectedUsername, credentials.getUsername());
    }
}
