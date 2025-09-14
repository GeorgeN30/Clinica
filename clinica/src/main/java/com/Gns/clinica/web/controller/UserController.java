package com.Gns.clinica.web.controller;

import com.Gns.clinica.domain.dto.request.UserDtoRequest;
import com.Gns.clinica.domain.dto.request.update.UpdateUserDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserStatusDto;
import com.Gns.clinica.domain.dto.response.UserDtoResponse;
import com.Gns.clinica.domain.enums.Role;
import com.Gns.clinica.domain.service.UserService;
import com.Gns.clinica.persistence.crud.CrudUserEntity;
import com.Gns.clinica.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDtoRequest> addPatient(@RequestBody UserDtoRequest userDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.userService.addPatient(userDtoRequest));
    }

    @PostMapping("/staff")
    public ResponseEntity<UserDtoRequest> addUser(@RequestBody UserDtoRequest userDtoRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.userService.addUser(userDtoRequest));
    }
    @GetMapping
    public ResponseEntity<List<UserDtoResponse>> findAll(){
        return ResponseEntity.ok(this.userService.getAll());
    }

    @GetMapping("/patients")
    public ResponseEntity<List<UserDtoResponse>> findAllByPatient(Role role){
        return ResponseEntity.ok(this.userService.getAllByRolPatient(role));
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<UserDtoResponse>> findAllByDoctor(Role role){
        return ResponseEntity.ok(this.userService.getAllByRolDoctor(role));
    }

    @GetMapping("/admins")
    public ResponseEntity<List<UserDtoResponse>> findAllByAdmin(Role role){
        return ResponseEntity.ok(this.userService.getAllByRolAdmin(role));
    }

    @GetMapping("/{dni}")
    public ResponseEntity<UserDtoResponse> findByDni(@PathVariable String dni) {
        if (dni.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.userService.getFirstByDni(dni));
    }

    @PutMapping("/{dni}")
    public ResponseEntity<UserDtoRequest> updateUser(@PathVariable String dni, @RequestBody UpdateUserDto updateUserDto) {
        if (dni.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.userService.updateUser(dni, updateUserDto));
    }

    @PatchMapping("/{dni}/status")
    public ResponseEntity<UserDtoRequest> updateUserStatus(@PathVariable String dni, @RequestBody UpdateUserStatusDto updateUserStatusDto) {
        if (dni.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.userService.updateUserStatus(dni, updateUserStatusDto));
    }


}
