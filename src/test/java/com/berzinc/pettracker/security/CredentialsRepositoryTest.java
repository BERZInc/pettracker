package com.berzinc.pettracker.security;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.google.common.collect.Iterables;

// @DataJpaTest
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CredentialsRepositoryTest {

    @Autowired
    CredentialsRepository credentialsRepository;


    @Test
    void findAll_whenNoRecords_returnsEmpty() {
        Iterable<Credentials> credentials = credentialsRepository.findAll();
        assertTrue(Iterables.isEmpty(credentials));
    }
}
