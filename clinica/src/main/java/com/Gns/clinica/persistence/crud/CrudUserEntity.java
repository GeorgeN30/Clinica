package com.Gns.clinica.persistence.crud;

import com.Gns.clinica.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudUserEntity extends CrudRepository<UserEntity, Long> {
}
