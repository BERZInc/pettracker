package com.berzinc.pettracker.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.berzinc.pettracker.security.Credentials;

@ExtendWith(MockitoExtension.class)
public class UserTest {

    @Mock
    private Credentials credentials;

    @Test
    void getFirstName_returnsFirstName() {
        String expectedFirstName = "some_firstName";
        User user = new User(expectedFirstName, "some_lastname", credentials);
        assertEquals(expectedFirstName, user.getFirstName());
    }

    @Test
    void getLastName_returnsLastName() {
        String expectedLastName = "some_lastName";
        User user = new User("some_firstName", expectedLastName, credentials);
        assertEquals(expectedLastName, user.getLastName());
    }

    @Test
    void getPassword_returnsCredentialsPassword() {
        String expectedPassword = "some_password";
        when(credentials.getPassword()).thenReturn(expectedPassword);
        User user = new User("some_firstName", "some_lastname", credentials);
        assertEquals(expectedPassword, user.getPassword());
    }

    @Test
    void getUsername_returnsCredentialsUsername() {
        String expectedUserName = "some_username";
        when(credentials.getUsername()).thenReturn(expectedUserName);
        User user = new User("some_firstName", "some_lastname", credentials);
        assertEquals(expectedUserName, user.getUsername());
    }
}
