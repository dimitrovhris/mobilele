package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.DTO.UserRegistrationDTO;
import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {
        userRepository.saveAndFlush(map(userRegistrationDTO));
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
