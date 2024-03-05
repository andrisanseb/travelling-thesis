package com.thesis.controller;

import com.thesis.model.DTO.UserDTO;
import com.thesis.model.User;
import com.thesis.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserController {

    private record UserSingleDTO (String status, UserDTO data) {}
    private record UserListDTO (String status, List<UserDTO> data) {}

    @Autowired
    UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    //ENDPOINTS

    //POST
    @PostMapping
    public ResponseEntity<UserSingleDTO> createUser(@RequestBody User user) {
        User userToCreate = user;

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new UserSingleDTO("success", modelMapper
                        .map(this.userRepository.save(userToCreate), UserDTO.class)
                ));
    }


    //GET
    @GetMapping
    public ResponseEntity<UserListDTO> getAllUsers() {
        return ResponseEntity
                .ok(new UserListDTO("success", this.userRepository.findAll().stream()
                        .map(x -> modelMapper
                                .map(x, UserDTO.class))
                        .collect(Collectors.toList())
                ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserSingleDTO> getUserById(@PathVariable int id) {
        return ResponseEntity
                .ok(new UserSingleDTO("success", this.userRepository.findById(id)
                        .map(x -> modelMapper
                        .map(x, UserDTO.class)).orElseThrow()
                ));
    }


    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<UserSingleDTO> updateUser(@PathVariable Integer id, @RequestBody User user) {
        User userToUpdate = this.userRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));

        //TODO: user can pass only one property changed, needs to check so it can keep the original for the rest
        userToUpdate.setUsername(user.getUsername());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setFirst_name(user.getFirst_name());
        userToUpdate.setLast_name(user.getLast_name());
        userToUpdate.setUpdatedAt();
        this.userRepository.save(userToUpdate);

        return ResponseEntity
                .ok(new UserSingleDTO("success", this.userRepository.findById(id)
                        .map(x -> modelMapper
                                .map(x, UserDTO.class)).orElseThrow()
                ));
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id) {
        User userToDelete = this.userRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
        this.userRepository.delete(userToDelete);
        return ResponseEntity.ok(userToDelete);
    }
}
