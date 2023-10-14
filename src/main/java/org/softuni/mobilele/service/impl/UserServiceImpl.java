package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.DTO.UserLoginDTO;
import org.softuni.mobilele.model.DTO.UserRegistrationDTO;
import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.service.UserService;
import org.softuni.mobilele.util.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        userRepository.save(map(userRegistrationDTO));
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {
        var userEntity = userRepository
                .findByEmail(userLoginDTO.email())
                .orElse(null);

        boolean loginSuccess = false;

        if(userEntity != null){
            String rawPassword = userLoginDTO.password();
            String encodedPassword = userEntity.getPassword();

            loginSuccess = encodedPassword != null &&
                    rawPassword.equals(encodedPassword);

            if(loginSuccess){
                currentUser.setLogged(true);
                currentUser.setFirstName(userEntity.getFirstName());
                currentUser.setLastName(userEntity.getLastName());
            }else {
                currentUser.logout();
            }
        }

        return loginSuccess;
    }

    private static UserEntity map(UserRegistrationDTO userRegistrationDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setActive(true);
        userEntity.setFirstName(userRegistrationDTO.firstName());
        userEntity.setLastName(userRegistrationDTO.lastName());
        userEntity.setPassword(userRegistrationDTO.password());
        userEntity.setEmail(userRegistrationDTO.email());;
        return userEntity;
    }
}
