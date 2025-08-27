package com.example.WebDeMusica.servis;

import com.example.WebDeMusica.dto.UserDtoRes;
import com.example.WebDeMusica.dto.dtoReq.UserDtoReq;
import com.example.WebDeMusica.entity.UserEntity;
import com.example.WebDeMusica.entity.UserEnum;
import com.example.WebDeMusica.exeption.NotFoundException;
import com.example.WebDeMusica.mapper.UserMapper;
import com.example.WebDeMusica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;

public class UserServisImpl implements UserServis {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    @Autowired
    private UserMapper modelMapper;  // Para convertir entre entidades y DTOs

    public UserServisImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDtoRes getUser(Long id) {

        return UserMapper.toDTO(userRepository.findById(id).orElseThrow(() -> new NotFoundException("no se encontro usuario")));
    }


    @Override
    public UserDtoRes createUser(UserDtoReq userDTOReq) {
        UserEntity user = UserMapper.toUserEntity(userDTOReq);

        // if (user.getProfileImage() == null || user.getProfileImage().isEmpty()) {
        //     user.setProfileImage("https://res.cloudinary.com/dmwsuzs94/image/upload/v1728906889/user_n1laeq.jpg");
        // }

        // Asegúrate de que estás codificando la contraseña
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user = userRepository.save(user);
        return UserMapper.toDTO(user);
    }

    public UserDtoRes getUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("El usuario con ID: " + id + "no fue encontrado"));
        return UserMapper.toDTO(user);
    }

    public UserDtoRes updateUser(Long id, UserDtoReq userDTOReq) {
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("El usuario con ID: " + id + "no fue encontrado"));

        existingUser.setNombreUsuario(userDTOReq.nombreUsuario());
        existingUser.setPassword(userDTOReq.password());
        existingUser.setEmail(userDTOReq.email());
        existingUser.setUserEnum(UserEnum.valueOf(userDTOReq.userEnum()));

        existingUser = userRepository.save(existingUser);
        return UserMapper.toDTO(existingUser);
    }

    public void deleteUser(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("El usuario con ID: " + id + "no fue encontrado"));
        userRepository.delete(user);
    }

    public List<UserDtoRes> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDtoRes updateProfileImage(Long id, String imageUrl) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));
        //user.setProfileImage(imageUrl);
        userRepository.save(user);
        return UserMapper.toDTO(user);
    }
}
