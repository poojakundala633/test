package com.example.demo.Service;

import com.example.demo.Dto.PostsDto;
import com.example.demo.Dto.UserDto;
import com.example.demo.Entity.Posts;
import com.example.demo.Entity.User;
import com.example.demo.Repository.PostsRepository;
import com.example.demo.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    private ModelMapper modelMapper;
    public UserServiceImpl() {modelMapper = new ModelMapper();}
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto getByUserId(int userId) {
        Optional<User> usersOptional = userRepository.findById(userId);
        return usersOptional.map(users -> modelMapper.map(users, UserDto.class)).orElse(null);
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        User userPosts  =  userRepository.save(user);
        return modelMapper.map(userPosts,UserDto.class);
    }
    @Override
    public UserDto updateUser(int userId, UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            User existingUser = userOptional.get();
            if(userDto.getEmail()!=null){
                existingUser.setEmail(userDto.getEmail());
            }
            User updateUser = userRepository.save(existingUser);
            return modelMapper.map(updateUser,UserDto.class);
        }else {
            return null;
        }
    }
    @Override
    public void deleteById(int userId) {
    userRepository.deleteById(userId);
    }
}
