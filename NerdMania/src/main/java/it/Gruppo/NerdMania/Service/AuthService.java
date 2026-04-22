package it.Gruppo.NerdMania.Service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public boolean login(String username, String password) {

        // TEMPORANEO (da sostituire con DB)
        return username.equals("admin") && password.equals("admin");
    }
}