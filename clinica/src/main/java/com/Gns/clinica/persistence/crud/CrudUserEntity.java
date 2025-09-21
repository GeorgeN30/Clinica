package com.Gns.clinica.persistence.crud;


import com.Gns.clinica.domain.enums.Role;
import com.Gns.clinica.persistence.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;


import java.util.List;
import java.util.Optional;

public interface CrudUserEntity extends ListCrudRepository<UserEntity, Long> {
    List<UserEntity> findAllByRole(Role role);
    Optional<UserEntity> findFirstByDni(String dni);
    Optional<UserEntity> findFirstByEmail(String email);
}
