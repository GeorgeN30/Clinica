package com.Gns.clinica.web.controller;

import com.Gns.clinica.domain.dto.request.BranchRequestDto;
import com.Gns.clinica.domain.dto.response.BranchPublicResponseDto;
import com.Gns.clinica.domain.dto.response.BranchResponseDto;
import com.Gns.clinica.domain.service.BranchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branch")
public class BranchController {
    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }
    @GetMapping
    public ResponseEntity<List<BranchResponseDto>> getAllBranches() {
        return ResponseEntity.ok(this.branchService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchResponseDto> getById(@PathVariable long id) {
        return ResponseEntity.ok(this.branchService.getById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<BranchPublicResponseDto> getByName(@PathVariable String name) {
        return ResponseEntity.ok(this.branchService.getByName(name));
    }

    @GetMapping("/name")
    public ResponseEntity<List<BranchPublicResponseDto>> getAllPublicBranches() {
        return ResponseEntity.ok(this.branchService.getAllPublic());
    }

    @PostMapping
    public ResponseEntity<BranchRequestDto> addBranch(@RequestBody BranchRequestDto branchRequestDto) {
        return ResponseEntity.ok(this.branchService.addBranch(branchRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BranchRequestDto> updateBranch(@PathVariable long id, @RequestBody BranchRequestDto branchRequestDto) {
        return ResponseEntity.ok(this.branchService.updateBranch(id, branchRequestDto));
    }

}
