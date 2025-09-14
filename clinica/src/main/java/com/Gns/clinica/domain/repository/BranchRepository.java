package com.Gns.clinica.domain.repository;

import com.Gns.clinica.domain.dto.request.BranchRequestDto;
import com.Gns.clinica.domain.dto.response.BranchPublicResponseDto;
import com.Gns.clinica.domain.dto.response.BranchResponseDto;

import java.util.List;

public interface BranchRepository {
    List<BranchResponseDto> getAll();
    BranchResponseDto getById(long id);
    BranchPublicResponseDto getByName(String name);
    List<BranchPublicResponseDto> getAllPublic();
    BranchRequestDto addBranch(BranchRequestDto branchRequestDto);
    BranchPublicResponseDto updateBranch(long id, BranchPublicResponseDto branchPublicResponseDto);

}
