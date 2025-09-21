package com.Gns.clinica.domain.service.impl;

import com.Gns.clinica.domain.dto.request.BranchRequestDto;
import com.Gns.clinica.domain.dto.response.BranchPublicResponseDto;
import com.Gns.clinica.domain.dto.response.BranchResponseDto;
import com.Gns.clinica.domain.exception.BranchAlreadyExistsException;
import com.Gns.clinica.domain.exception.BranchNotFoundByIdException;
import com.Gns.clinica.domain.exception.BranchNotFoundByNameException;
import com.Gns.clinica.domain.repository.BranchRepository;
import com.Gns.clinica.domain.service.interfaces.BranchService;
import com.Gns.clinica.persistence.entity.BranchEntity;
import com.Gns.clinica.persistence.mapper.BranchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;
    private final BranchMapper branchMapper;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, BranchMapper branchMapper) {
        this.branchRepository = branchRepository;
        this.branchMapper = branchMapper;
    }

    @Override
    public List<BranchResponseDto> getAll() {
        return this.branchRepository.findAll()
                .stream()
                .map(branchMapper::toResponseDto)
                .toList();
    }

    @Override
    public BranchResponseDto getById(long id) {
        return this.branchRepository.findById(id)
                .map(branchMapper::toResponseDto)
                .orElseThrow(()-> new BranchNotFoundByIdException(id));
    }

    @Override
    public BranchPublicResponseDto getByName(String name) {
        return this.branchRepository.findByName(name)
                .map(branchMapper::toPublicResponseDto)
                .orElseThrow(()-> new BranchNotFoundByNameException(name));
    }

    @Override
    public List<BranchPublicResponseDto> getAllPublic() {
        return this.branchRepository.findAll()
                .stream()
                .map(branchMapper::toPublicResponseDto)
                .toList();
    }

    @Override
    public BranchPublicResponseDto addBranch(BranchRequestDto branchRequestDto) {
        this.branchRepository.findByName(branchRequestDto.name())
                .ifPresent(entity -> {
                    throw new BranchAlreadyExistsException(branchRequestDto.name());
                });
        BranchEntity branchEntity = branchMapper.toEntity(branchRequestDto);
        return this.branchMapper.toPublicResponseDto(this.branchRepository.save(branchEntity));
    }

    @Override
    public BranchPublicResponseDto updateBranch(long id, BranchRequestDto branchRequestDto) {
        BranchEntity existing = this.branchRepository.findById(id)
                .orElseThrow(()-> new BranchNotFoundByIdException(id));
           existing.setName(branchRequestDto.name());
           existing.setAddress(branchRequestDto.address());
           existing.setPhone(branchRequestDto.phone());

           BranchEntity branchEntity = this.branchRepository.save(existing);
           return this.branchMapper.toPublicResponseDto(branchEntity);

    }
}
