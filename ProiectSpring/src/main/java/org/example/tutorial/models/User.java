package org.example.tutorial.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User extends  AbstractEntity{
    @NotNull
    private String username;
    @NotNull
    private String password;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.password = encoder.encode(password);
    }
    public User(){}
    public boolean PasswordMatch(String password){
        return encoder.matches(password,this.password);
    }
    public String getUsername(){
        return username;
    }
}
