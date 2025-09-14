package com.Gns.clinica.domain.service;

import com.Gns.clinica.domain.dto.request.BranchRequestDto;
import com.Gns.clinica.domain.dto.response.BranchPublicResponseDto;
import com.Gns.clinica.domain.dto.response.BranchResponseDto;
import com.Gns.clinica.domain.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {
    private final BranchRepository branchRepository;

    @Autowired
    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public List<BranchResponseDto> getAll() {
        return this.branchRepository.getAll();
    }

    public BranchResponseDto getById(long id) {
        return this.branchRepository.getById(id);
    }

    public BranchPublicResponseDto getByName(String name) {
        return this.branchRepository.getByName(name);
    }

    public List<BranchPublicResponseDto> getAllPublic() {
        return this.branchRepository.getAllPublic();
    }

    public BranchRequestDto addBranch(BranchRequestDto branchRequestDto) {
        return this.branchRepository.addBranch(branchRequestDto);
    }

    public BranchPublicResponseDto updateBranch(long id, BranchPublicResponseDto branchPublicResponseDto) {
        return this.branchRepository.updateBranch(id, branchPublicResponseDto);
    }

}
