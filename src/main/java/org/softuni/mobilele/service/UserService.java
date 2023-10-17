package org.softuni.mobilele.service;


import org.softuni.mobilele.model.DTO.UserLoginDTO;
import org.softuni.mobilele.model.DTO.UserRegistrationDTO;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);

    boolean loginUser(UserLoginDTO userLoginDTO);

    void logoutUser();
}
