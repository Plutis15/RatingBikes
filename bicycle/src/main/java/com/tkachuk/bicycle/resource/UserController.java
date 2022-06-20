package com.tkachuk.bicycle.resource;

import com.tkachuk.bicycle.entity.UserEntity;
import com.tkachuk.bicycle.entity.enums.UserDTO;
import com.tkachuk.bicycle.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/add")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user) {
        UserEntity newUser = userService.saveUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/findUser/{id}")
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity findUserDTOById(@PathVariable("id") Long id) {
        UserDTO user2 = userService.findUserDtoById(id);
        return new ResponseEntity<>(user2, HttpStatus.OK);
    }
}
