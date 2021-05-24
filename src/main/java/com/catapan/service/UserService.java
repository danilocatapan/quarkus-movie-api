package com.catapan.service;

import com.catapan.exception.BusinessException;
import com.catapan.model.User;
import com.catapan.model.dto.UserRequestDTO;
import com.catapan.model.dto.UserResponseDTO;
import com.catapan.repository.UserRepository;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    @Transactional
    public UserResponseDTO create(UserRequestDTO userDTO) {

        Optional<User> userOptional = userRepository.findByEmail(userDTO.getEmail());

        if (userOptional.isPresent()) {
            throw new BusinessException("Usuário já cadastrado com esta e-mail!");
        }

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        userRepository.persist(user);

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        return userResponseDTO;
    }
}
