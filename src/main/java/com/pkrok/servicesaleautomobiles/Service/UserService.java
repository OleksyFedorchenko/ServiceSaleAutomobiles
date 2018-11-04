package com.pkrok.servicesaleautomobiles.Service;

import com.pkrok.servicesaleautomobiles.Domain.UserDTO;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO user);

    List<UserDTO> findAllUsers();

    UserDTO findUserById(Long id);

    void deleteUserById(Long id);
}
