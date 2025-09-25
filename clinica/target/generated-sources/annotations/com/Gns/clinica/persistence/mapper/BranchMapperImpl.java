package com.Gns.clinica.persistence.mapper;

import com.Gns.clinica.domain.dto.request.BranchRequestDto;
import com.Gns.clinica.domain.dto.response.BranchPublicResponseDto;
import com.Gns.clinica.domain.dto.response.BranchResponseDto;
import com.Gns.clinica.persistence.entity.BranchEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-24T22:12:03-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class BranchMapperImpl implements BranchMapper {

    @Override
    public BranchResponseDto toResponseDto(BranchEntity branchEntity) {
        if ( branchEntity == null ) {
            return null;
        }

        String name = null;
        String address = null;
        String phone = null;
        Long idBranch = null;

        name = branchEntity.getName();
        address = branchEntity.getAddress();
        phone = branchEntity.getPhone();
        idBranch = branchEntity.getIdBranch();

        BranchResponseDto branchResponseDto = new BranchResponseDto( idBranch, name, address, phone );

        return branchResponseDto;
    }

    @Override
    public List<BranchResponseDto> toResponseDto(List<BranchEntity> branchEntities) {
        if ( branchEntities == null ) {
            return null;
        }

        List<BranchResponseDto> list = new ArrayList<BranchResponseDto>( branchEntities.size() );
        for ( BranchEntity branchEntity : branchEntities ) {
            list.add( toResponseDto( branchEntity ) );
        }

        return list;
    }

    @Override
    public BranchPublicResponseDto toPublicResponseDto(BranchEntity branchEntity) {
        if ( branchEntity == null ) {
            return null;
        }

        String name = null;
        String address = null;
        String phone = null;

        name = branchEntity.getName();
        address = branchEntity.getAddress();
        phone = branchEntity.getPhone();

        BranchPublicResponseDto branchPublicResponseDto = new BranchPublicResponseDto( name, address, phone );

        return branchPublicResponseDto;
    }

    @Override
    public List<BranchPublicResponseDto> toPublicResponseDto(List<BranchEntity> branchEntities) {
        if ( branchEntities == null ) {
            return null;
        }

        List<BranchPublicResponseDto> list = new ArrayList<BranchPublicResponseDto>( branchEntities.size() );
        for ( BranchEntity branchEntity : branchEntities ) {
            list.add( toPublicResponseDto( branchEntity ) );
        }

        return list;
    }

    @Override
    public BranchEntity toEntity(BranchRequestDto branchRequestDto) {
        if ( branchRequestDto == null ) {
            return null;
        }

        BranchEntity.BranchEntityBuilder branchEntity = BranchEntity.builder();

        branchEntity.name( branchRequestDto.name() );
        branchEntity.address( branchRequestDto.address() );
        branchEntity.phone( branchRequestDto.phone() );

        return branchEntity.build();
    }

    @Override
    public BranchRequestDto toRequestDto(BranchEntity branchEntity) {
        if ( branchEntity == null ) {
            return null;
        }

        String name = null;
        String address = null;
        String phone = null;

        name = branchEntity.getName();
        address = branchEntity.getAddress();
        phone = branchEntity.getPhone();

        BranchRequestDto branchRequestDto = new BranchRequestDto( name, address, phone );

        return branchRequestDto;
    }
}
