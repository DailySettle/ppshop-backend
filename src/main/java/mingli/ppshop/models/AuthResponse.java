package mingli.ppshop.models;

import lombok.Data;

@Data
public class AuthResponse {
    private final String username;
    private final String jwt;
}
