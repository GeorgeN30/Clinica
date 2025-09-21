package com.Gns.clinica.persistence.repository;

import com.Gns.clinica.domain.enums.Role;
import com.Gns.clinica.domain.repository.UserRepository;
import com.Gns.clinica.persistence.crud.CrudUserEntity;
import com.Gns.clinica.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class UserEntityRepository implements UserRepository {
    private final CrudUserEntity crudUserEntity;


    @Autowired
    public UserEntityRepository(CrudUserEntity crudUserEntity) {
        this.crudUserEntity = crudUserEntity;
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return this.crudUserEntity.save(userEntity);
    }

    @Override
    public Optional<UserEntity> findById(long id) {
        return this.crudUserEntity.findById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return this.crudUserEntity.findAll();
    }

    @Override
    public List<UserEntity> findAllByRole(Role role) {
        return this.crudUserEntity.findAllByRole(role);
    }

    @Override
    public Optional<UserEntity> findFirstByDni(String dni) {
        return this.crudUserEntity.findFirstByDni(dni);
    }

    @Override
    public Optional<UserEntity> findFirstByEmail(String email) {
        return this.crudUserEntity.findFirstByEmail(email);
    }
}
