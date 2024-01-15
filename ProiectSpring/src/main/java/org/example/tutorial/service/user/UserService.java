package org.example.tutorial.service.user;

import org.example.tutorial.models.RegistrationRequest;
import org.example.tutorial.models.User;
import org.example.tutorial.models.dto.UserDto;

import java.util.List;

public interface UserService {

    boolean checkEmail(String email);

    UserDto registerUser(RegistrationRequest registrationRequest);

    UserDto getLoginUser();

    UserDto getUserById(Integer id);

    List<UserDto> getAllUsers();

    UserDto createUser(User user);

    UserDto updateUser(User user);

    void deleteUser(User user);
}