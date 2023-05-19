package com.berzinc.pettracker.security;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.berzinc.pettracker.users.User;
import com.berzinc.pettracker.users.UserRepository;
import com.berzinc.pettracker.users.UserRole;
import com.berzinc.pettracker.users.UserRoleRepository;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthenticationService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private RefreshTokenGenerator refreshTokenGenerator;

	@Autowired
	private PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;


    public User registerNewUser(RegisterUserRequest registerUserRequest) {
        if(userRepository.existsByUsername(registerUserRequest.getUsername())){
            throw new IllegalArgumentException("User already exists");
        }

        String encodedPassword = encoder.encode(registerUserRequest.getPassword());
        UserRole userRole = new UserRole();
        userRole.setRole(registerUserRequest.getRole());
        User newUser = new User(
            registerUserRequest.getUsername(), 
            encodedPassword, 
            registerUserRequest.getFirstName(),
            registerUserRequest.getLastName(),
            userRole);
        userRole.setUser(newUser);

        User savedUser = userRepository.save(newUser);
        userRoleRepository.save(userRole);

        return savedUser;
    }

    public AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest) {
        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("user not found"));

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(username, password));

        AccessToken accessToken = jwtTokenProvider.generateJwtToken(user);
        RefreshToken refreshToken = refreshTokenRepository.save(refreshTokenGenerator.apply(user));

        List<String> userRoles = user.getRoles().stream().map(role -> role.getRole().name())
        .collect(Collectors.toList());

        return new AuthenticationResponse(
            accessToken, 
            refreshToken,
            user.getId(), 
            user.getUsername(), 
            userRoles);

    }
    
    public AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        
        RefreshToken refreshToken = refreshTokenRepository.findByToken(refreshTokenRequest.getRefreshToken())
        .orElseThrow(() -> new IllegalStateException(refreshTokenRequest 
            + " Refresh token is not in database!"));

        verifyExpiration(refreshToken);

        User user = refreshToken.getUser();

        AccessToken accessToken = jwtTokenProvider.generateJwtToken(user);
        
        List<String> userRoles = user.getRoles().stream().map(role -> role.getRole().name())
        .collect(Collectors.toList());

        return new AuthenticationResponse(
            accessToken, 
            refreshToken,
            user.getId(), 
            user.getUsername(), 
            userRoles);
    }

    private RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpirationDate().compareTo(new Date()) < 0) {
          refreshTokenRepository.delete(token);
          throw new IllegalStateException(token.getToken() + " Refresh token was expired. Please make a new signin request");
        }
    
        return token;
      }

}
