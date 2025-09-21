package com.Gns.clinica.web.controller;

import com.Gns.clinica.domain.dto.request.UserRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserStatusDto;
import com.Gns.clinica.domain.dto.response.UserPublicResponseDto;
import com.Gns.clinica.domain.dto.response.UserResponseDto;
import com.Gns.clinica.domain.enums.Role;
import com.Gns.clinica.domain.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserServiceImpl userService;


    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserPublicResponseDto> addPatient(@Valid @RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.userService.addPatient(userRequestDto));
    }

    @PostMapping("/staff")
    public ResponseEntity<UserPublicResponseDto> addUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.userService.addUser(userRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll(){
        return ResponseEntity.ok(this.userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(this.userService.getById(id));
    }

    @GetMapping("/patients")
    public ResponseEntity<List<UserResponseDto>> getAllByPatients(){
        return ResponseEntity.ok(this.userService.getAllByRolePatient(Role.PATIENT));
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<UserResponseDto>> getAllByDoctors(){
        return ResponseEntity.ok(this.userService.getAllByRoleDoctor(Role.DOCTOR));
    }

    @GetMapping("/admins")
    public ResponseEntity<List<UserResponseDto>> getAllByAdmins(){
        return ResponseEntity.ok(this.userService.getAllByRoleAdmin(Role.ADMIN));
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<UserPublicResponseDto> findByDni(@PathVariable String dni) {
        if (dni.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.userService.getFirstByDni(dni));
    }

    @PutMapping("/{dni}")
    public ResponseEntity<UserPublicResponseDto> updateUser(@PathVariable String dni, @Valid @RequestBody UpdateUserDto updateUserDto) {
        if (dni.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.userService.updateUser(dni, updateUserDto));
    }

    @PatchMapping("/{dni}/status")
    public ResponseEntity<UserPublicResponseDto> updateUserStatus(@PathVariable String dni, @Valid @RequestBody UpdateUserStatusDto updateUserStatusDto) {
        if (dni.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.userService.updateUserStatus(dni, updateUserStatusDto));
    }


}
