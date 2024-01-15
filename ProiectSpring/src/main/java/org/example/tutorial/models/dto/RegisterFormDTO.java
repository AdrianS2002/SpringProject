package org.example.tutorial.models.dto;

public class RegisterFormDTO extends LoginFormDTO{
    private String passwordConfirmation;
    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }
}
