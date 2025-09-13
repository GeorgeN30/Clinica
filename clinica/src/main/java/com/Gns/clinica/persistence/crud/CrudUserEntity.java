package com.Gns.clinica.persistence.crud;


import com.Gns.clinica.domain.enums.Role;
import com.Gns.clinica.persistence.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;


import java.util.List;

public interface CrudUserEntity extends ListCrudRepository<UserEntity, Long> {
    List<UserEntity> findAllByRole(Role role);
    UserEntity findFirstByDni(String dni);
}
