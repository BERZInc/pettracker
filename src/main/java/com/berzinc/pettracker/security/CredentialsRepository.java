package com.berzinc.pettracker.security;

import org.springframework.data.repository.CrudRepository;

public interface CredentialsRepository extends CrudRepository<Credentials, Integer> {
}
