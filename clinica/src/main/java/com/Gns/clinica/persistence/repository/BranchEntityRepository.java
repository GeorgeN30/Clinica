package com.Gns.clinica.persistence.repository;

import com.Gns.clinica.domain.dto.request.BranchRequestDto;
import com.Gns.clinica.domain.dto.response.BranchPublicResponseDto;
import com.Gns.clinica.domain.dto.response.BranchResponseDto;
import com.Gns.clinica.domain.repository.BranchRepository;
import com.Gns.clinica.persistence.crud.CrudBranchEntity;
import com.Gns.clinica.persistence.entity.BranchEntity;
import com.Gns.clinica.persistence.mapper.BranchMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BranchEntityRepository implements BranchRepository {
    private final CrudBranchEntity crudBranchEntity;
    private final BranchMapper branchMapper;

    public BranchEntityRepository(CrudBranchEntity crudBranchEntity, BranchMapper branchMapper) {
        this.crudBranchEntity = crudBranchEntity;
        this.branchMapper = branchMapper;
    }

    @Override
    public List<BranchResponseDto> getAll() {
        return this.branchMapper.toResponseDto(crudBranchEntity.findAll());
    }

    @Override
    public BranchResponseDto getById(long id) {
        return this.branchMapper.toResponseDto(this.crudBranchEntity.findById(id).orElse(null));
    }

    @Override
    public BranchPublicResponseDto getByName(String name) {
        return this.branchMapper.toPublicResponseDto(this.crudBranchEntity.findByName(name));
    }

    @Override
    public List<BranchPublicResponseDto> getAllPublic() {
        return this.branchMapper.toPublicResponseDto(this.crudBranchEntity.findAll());
    }

    @Override
    public BranchRequestDto addBranch(BranchRequestDto branchRequestDto) {
        BranchEntity branchEntity = this.branchMapper.toEntity(branchRequestDto);
        return this.branchMapper.toRequestDto(this.crudBranchEntity.save(branchEntity));
    }

    @Override
    public BranchRequestDto updateBranch(long id, BranchRequestDto branchRequestDto) {
        BranchEntity branchEntity = this.crudBranchEntity.findById(id).orElse(null);
        if (branchEntity == null) {
            return null;
        }
        this.branchMapper.updateEntityFromDto(branchRequestDto, branchEntity);
        return this.branchMapper.toRequestDto(this.crudBranchEntity.save(branchEntity));
    }
}
