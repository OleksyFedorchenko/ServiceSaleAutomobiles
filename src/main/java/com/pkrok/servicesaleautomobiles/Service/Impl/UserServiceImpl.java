package com.pkrok.servicesaleautomobiles.Service.Impl;

import com.pkrok.servicesaleautomobiles.Domain.UserDTO;
import com.pkrok.servicesaleautomobiles.Entity.UserEntity;
import com.pkrok.servicesaleautomobiles.Repository.UserRepository;
import com.pkrok.servicesaleautomobiles.Service.UserService;
import com.pkrok.servicesaleautomobiles.Utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void saveUser(UserDTO user) {
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        userRepository.save(userEntity);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDTO> userDTOS = modelMapper.mapAll(userEntities, UserDTO.class);
        return userDTOS;
    }

    @Override
    public UserDTO findUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
        return userDTO;
    }

    @Override
    public void deleteUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        if (userEntity != null) {
            userRepository.deleteById(id);
        } else System.out.println("User not found");
    }

}
