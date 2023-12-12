package com.example.demo.Service;

import com.example.demo.Dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getByUserId(int userId);
    UserDto saveUser(UserDto userDto);
    UserDto updateUser(int userId, UserDto userDto);
    void deleteById(int userId);
}
