package com.Gns.clinica.domain.service.interfaces;

import com.Gns.clinica.domain.dto.request.BranchRequestDto;
import com.Gns.clinica.domain.dto.response.BranchPublicResponseDto;
import com.Gns.clinica.domain.dto.response.BranchResponseDto;

import java.util.List;

public interface BranchService {
    List<BranchResponseDto> getAll();
    BranchResponseDto getById(long id);
    BranchPublicResponseDto getByName(String name);
    List<BranchPublicResponseDto> getAllPublic();
    BranchPublicResponseDto addBranch(BranchRequestDto branchRequestDto);
    BranchPublicResponseDto updateBranch(long id, BranchRequestDto branchRequestDto);
}
