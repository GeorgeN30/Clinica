package com.Gns.clinica.web.controller;

import com.Gns.clinica.domain.dto.request.UserRequestDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserDto;
import com.Gns.clinica.domain.dto.request.update.UpdateUserStatusDto;
import com.Gns.clinica.domain.dto.response.UserPublicResponseDto;
import com.Gns.clinica.domain.dto.response.UserResponseDto;
import com.Gns.clinica.domain.enums.Role;
import com.Gns.clinica.domain.service.UserService;
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
    public ResponseEntity<UserRequestDto> addPatient(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.userService.addPatient(userRequestDto));
    }

    @PostMapping("/staff")
    public ResponseEntity<UserRequestDto> addUser(@RequestBody UserRequestDto userRequestDto) {
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
    public ResponseEntity<List<UserResponseDto>> getAllByPatient(Role role){
        return ResponseEntity.ok(this.userService.getAllByRolPatient(role));
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<UserResponseDto>> getAllByDoctor(Role role){
        return ResponseEntity.ok(this.userService.getAllByRolDoctor(role));
    }

    @GetMapping("/admins")
    public ResponseEntity<List<UserResponseDto>> getAllByAdmin(Role role){
        return ResponseEntity.ok(this.userService.getAllByRolAdmin(role));
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<UserPublicResponseDto> findByDni(@PathVariable String dni) {
        if (dni.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.userService.getFirstByDni(dni));
    }

    @PutMapping("/{dni}")
    public ResponseEntity<UserRequestDto> updateUser(@PathVariable String dni, @RequestBody UpdateUserDto updateUserDto) {
        if (dni.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.userService.updateUser(dni, updateUserDto));
    }

    @PatchMapping("/{dni}/status")
    public ResponseEntity<UserRequestDto> updateUserStatus(@PathVariable String dni, @RequestBody UpdateUserStatusDto updateUserStatusDto) {
        if (dni.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.userService.updateUserStatus(dni, updateUserStatusDto));
    }


}
