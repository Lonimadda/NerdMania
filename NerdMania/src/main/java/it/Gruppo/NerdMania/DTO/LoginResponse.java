package it.Gruppo.NerdMania.DTO;

public class LoginResponse {

    private String message;
    private String token;
    private UserDto user;

    public LoginResponse(String message, String token,  UserDto user) {
        this.message = message;
        this.token = token;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

    public UserDto getUser() {return user;}
}