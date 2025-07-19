package com.dev.hrm_api.services.jwt;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    /**
     * Generates a JWT token for the given user details.
     * 
     * @param userDetails the user details for which the token is to be generated
     * @return the generated JWT token
     */
    String generateToken(UserDetails userDetails);

    /**
     * Extracts the username from the given JWT token.
     * 
     * @param token
     * @return the username extracted from the token
     */
    String extractUsername(String token);

    /**
     * Validates the given JWT token against the provided user details.
     * 
     * @param token       the JWT token to validate
     * @param userDetails the user details to validate against
     * @return true if the token is valid, false otherwise
     */
    boolean isTokenValid(String token, UserDetails userDetails);

}
