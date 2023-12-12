package com.example.demo.Controller;

import com.example.demo.Dto.UserDto;
import com.example.demo.Service.PostService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
        @Autowired
        private UserService userService;


        @GetMapping
        public ResponseEntity<List<UserDto>> findAllUsers(){
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<UserDto> saveUsers(@RequestBody UserDto userDto){
            return new ResponseEntity<>(userService.saveUser(userDto),HttpStatus.CREATED);
        }
        @PatchMapping("/{userId}")
        public ResponseEntity<UserDto> updateUserById(@PathVariable int userId, @RequestBody UserDto userDto) {
            UserDto updatedUser = userService.updateUser(userId,userDto);
            if (updatedUser != null) {
                return new ResponseEntity<>(updatedUser, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/{userId}")
        public ResponseEntity<Void> deleteById(@PathVariable int userId) {
            userService.deleteById(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @GetMapping("/{userId}")
        public ResponseEntity<UserDto> getUserById(@PathVariable int userId) {
            UserDto userDto = userService.getByUserId(userId);
            if (userDto != null) {
                return new ResponseEntity<>(userDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }

