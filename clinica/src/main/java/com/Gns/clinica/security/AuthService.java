package com.Gns.clinica.security;


import com.Gns.clinica.domain.repository.UserRepository;
import com.Gns.clinica.persistence.entity.UserEntity;
import com.Gns.clinica.security.config.JwtUtil;
import com.Gns.clinica.security.dto.AuthResponseDto;
import com.Gns.clinica.security.dto.LoginDto;
import com.Gns.clinica.security.dto.RefreshTokenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserSecurityService userSecurityService;
    private final UserRepository userRepository;

    @Autowired
    public AuthService(AuthenticationManager authenticationManager,
                       JwtUtil jwtUtil,
                       UserSecurityService userSecurityService, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userSecurityService = userSecurityService;
        this.userRepository = userRepository;
    }

    public AuthResponseDto login(LoginDto request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken
                        (request.getEmail(), request.getPassword())
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        UserEntity user = userRepository.findFirstByEmail(userDetails.getUsername())
                .orElseThrow(()-> new UsernameNotFoundException("user not found"));

        String accessToken = jwtUtil.generateAccessToken(userDetails.getUsername());
        String refreshToken = jwtUtil.generateRefreshToken(userDetails.getUsername());

        AuthResponseDto response = new AuthResponseDto();
        response.setAccess_token(accessToken);
        response.setRefresh_token(refreshToken);
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().name());
        return response;
    }

    public AuthResponseDto refreshToken(RefreshTokenDto request) {
        String refreshToken = request.getToken();
        if (!jwtUtil.verifyJwt(refreshToken)) {
            throw new RuntimeException("Invalid refresh token");
        }

        String username = jwtUtil.getUsername(refreshToken);
        UserDetails userDetails = userSecurityService.loadUserByUsername(username);

        String newAccessToken = jwtUtil.generateAccessToken(userDetails.getUsername());
        String newRefreshToken = jwtUtil.generateRefreshToken(userDetails.getUsername());

        AuthResponseDto response = new AuthResponseDto();
        response.setAccess_token(newAccessToken);
        response.setRefresh_token(newRefreshToken);
        return response;
    }
}
