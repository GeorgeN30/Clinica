package com.Gns.clinica.domain.repository;

import com.Gns.clinica.domain.enums.Role;
import com.Gns.clinica.persistence.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    UserEntity save(UserEntity userEntity);
    Optional<UserEntity> findById(long id);
    List<UserEntity> findAll();
    List<UserEntity> findAllByRole(Role role);
    Optional<UserEntity> findFirstByDni(String dni);
    Optional<UserEntity> findFirstByEmail(String email);
}
