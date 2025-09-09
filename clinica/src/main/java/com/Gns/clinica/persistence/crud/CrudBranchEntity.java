package com.Gns.clinica.persistence.crud;

import com.Gns.clinica.persistence.entity.BranchEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface CrudBranchEntity extends ListCrudRepository<BranchEntity, Long> {
}
