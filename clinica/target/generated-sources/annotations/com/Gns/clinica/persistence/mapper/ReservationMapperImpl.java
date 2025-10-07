package com.Gns.clinica.persistence.mapper;

import com.Gns.clinica.domain.dto.request.ReservationRequestDto;
import com.Gns.clinica.domain.dto.response.ReservationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ReservationResponseDto;
import com.Gns.clinica.domain.enums.ReservationStatus;
import com.Gns.clinica.persistence.entity.AvailabilityEntity;
import com.Gns.clinica.persistence.entity.BranchEntity;
import com.Gns.clinica.persistence.entity.ReservationEntity;
import com.Gns.clinica.persistence.entity.SpecialtyEntity;
import com.Gns.clinica.persistence.entity.UserEntity;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-07T17:51:39-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public ReservationResponseDto toResponseDto(ReservationEntity reservationEntity) {
        if ( reservationEntity == null ) {
            return null;
        }

        Long idReservation = null;
        Long idPatient = null;
        String namePatient = null;
        Long idDoctor = null;
        String nameDoctor = null;
        String nameSpecialty = null;
        Long idBranch = null;
        String nameBranch = null;
        Long idAvailability = null;
        LocalDate availabilityDate = null;
        LocalTime availabilityStart = null;
        LocalTime availabilityEnd = null;
        LocalDate reservationDate = null;
        LocalTime reservationTime = null;
        ReservationStatus status = null;

        idReservation = reservationEntity.getIdReservation();
        idPatient = reservationEntityPatientIdUser( reservationEntity );
        namePatient = reservationEntityPatientFirstName( reservationEntity );
        idDoctor = reservationEntityDoctorIdUser( reservationEntity );
        nameDoctor = reservationEntityDoctorFirstName( reservationEntity );
        nameSpecialty = reservationEntityDoctorSpecialtiesNameSpecialty( reservationEntity );
        idBranch = reservationEntityBranchIdBranch( reservationEntity );
        nameBranch = reservationEntityBranchName( reservationEntity );
        idAvailability = reservationEntityAvailabilityIdAvailability( reservationEntity );
        availabilityDate = reservationEntityAvailabilityDate( reservationEntity );
        availabilityStart = reservationEntityAvailabilityStartTime( reservationEntity );
        availabilityEnd = reservationEntityAvailabilityEndTime( reservationEntity );
        reservationDate = reservationEntity.getReservationDate();
        reservationTime = reservationEntity.getReservationTime();
        status = reservationEntity.getStatus();

        ReservationResponseDto reservationResponseDto = new ReservationResponseDto( idReservation, idPatient, namePatient, idDoctor, nameDoctor, nameSpecialty, idBranch, nameBranch, idAvailability, availabilityDate, availabilityStart, availabilityEnd, reservationDate, reservationTime, status );

        return reservationResponseDto;
    }

    @Override
    public List<ReservationResponseDto> toResponseDto(List<ReservationEntity> reservationEntityList) {
        if ( reservationEntityList == null ) {
            return null;
        }

        List<ReservationResponseDto> list = new ArrayList<ReservationResponseDto>( reservationEntityList.size() );
        for ( ReservationEntity reservationEntity : reservationEntityList ) {
            list.add( toResponseDto( reservationEntity ) );
        }

        return list;
    }

    @Override
    public ReservationPublicResponseDto toPublicResponseDto(ReservationEntity reservationEntity) {
        if ( reservationEntity == null ) {
            return null;
        }

        Long idReservation = null;
        String namePatient = null;
        String nameDoctor = null;
        String nameSpecialty = null;
        String nameBranch = null;
        LocalDate availabilityDate = null;
        LocalTime availabilityStart = null;
        LocalTime availabilityEnd = null;
        LocalDate reservationDate = null;
        LocalTime reservationTime = null;
        ReservationStatus status = null;

        idReservation = reservationEntity.getIdReservation();
        namePatient = reservationEntityPatientFirstName( reservationEntity );
        nameDoctor = reservationEntityDoctorFirstName( reservationEntity );
        nameSpecialty = reservationEntityDoctorSpecialtiesNameSpecialty( reservationEntity );
        nameBranch = reservationEntityBranchName( reservationEntity );
        availabilityDate = reservationEntityAvailabilityDate( reservationEntity );
        availabilityStart = reservationEntityAvailabilityStartTime( reservationEntity );
        availabilityEnd = reservationEntityAvailabilityEndTime( reservationEntity );
        reservationDate = reservationEntity.getReservationDate();
        reservationTime = reservationEntity.getReservationTime();
        status = reservationEntity.getStatus();

        ReservationPublicResponseDto reservationPublicResponseDto = new ReservationPublicResponseDto( idReservation, namePatient, nameDoctor, nameSpecialty, nameBranch, availabilityDate, availabilityStart, availabilityEnd, reservationDate, reservationTime, status );

        return reservationPublicResponseDto;
    }

    @Override
    public List<ReservationPublicResponseDto> toPublicResponseDto(List<ReservationEntity> reservationEntityList) {
        if ( reservationEntityList == null ) {
            return null;
        }

        List<ReservationPublicResponseDto> list = new ArrayList<ReservationPublicResponseDto>( reservationEntityList.size() );
        for ( ReservationEntity reservationEntity : reservationEntityList ) {
            list.add( toPublicResponseDto( reservationEntity ) );
        }

        return list;
    }

    @Override
    public ReservationRequestDto toRequestDto(ReservationEntity reservationEntity) {
        if ( reservationEntity == null ) {
            return null;
        }

        Long idPatient = null;
        Long idDoctor = null;
        Long idAvailability = null;
        Long idBranch = null;

        idPatient = reservationEntityPatientIdUser( reservationEntity );
        idDoctor = reservationEntityDoctorIdUser( reservationEntity );
        idAvailability = reservationEntityAvailabilityIdAvailability( reservationEntity );
        idBranch = reservationEntityBranchIdBranch( reservationEntity );

        ReservationRequestDto reservationRequestDto = new ReservationRequestDto( idPatient, idDoctor, idBranch, idAvailability );

        return reservationRequestDto;
    }

    @Override
    public ReservationEntity toEntity(ReservationRequestDto reservationRequestDto) {
        if ( reservationRequestDto == null ) {
            return null;
        }

        ReservationEntity.ReservationEntityBuilder reservationEntity = ReservationEntity.builder();

        reservationEntity.patient( reservationRequestDtoToUserEntity( reservationRequestDto ) );
        reservationEntity.doctor( reservationRequestDtoToUserEntity1( reservationRequestDto ) );
        reservationEntity.availability( reservationRequestDtoToAvailabilityEntity( reservationRequestDto ) );
        reservationEntity.branch( reservationRequestDtoToBranchEntity( reservationRequestDto ) );

        return reservationEntity.build();
    }

    private Long reservationEntityPatientIdUser(ReservationEntity reservationEntity) {
        if ( reservationEntity == null ) {
            return null;
        }
        UserEntity patient = reservationEntity.getPatient();
        if ( patient == null ) {
            return null;
        }
        Long idUser = patient.getIdUser();
        if ( idUser == null ) {
            return null;
        }
        return idUser;
    }

    private String reservationEntityPatientFirstName(ReservationEntity reservationEntity) {
        if ( reservationEntity == null ) {
            return null;
        }
        UserEntity patient = reservationEntity.getPatient();
        if ( patient == null ) {
            return null;
        }
        String firstName = patient.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private Long reservationEntityDoctorIdUser(ReservationEntity reservationEntity) {
        if ( reservationEntity == null ) {
            return null;
        }
        UserEntity doctor = reservationEntity.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        Long idUser = doctor.getIdUser();
        if ( idUser == null ) {
            return null;
        }
        return idUser;
    }

    private String reservationEntityDoctorFirstName(ReservationEntity reservationEntity) {
        if ( reservationEntity == null ) {
            return null;
        }
        UserEntity doctor = reservationEntity.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        String firstName = doctor.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String reservationEntityDoctorSpecialtiesNameSpecialty(ReservationEntity reservationEntity) {
        if ( reservationEntity == null ) {
            return null;
        }
        UserEntity doctor = reservationEntity.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        SpecialtyEntity specialties = doctor.getSpecialties();
        if ( specialties == null ) {
            return null;
        }
        String nameSpecialty = specialties.getNameSpecialty();
        if ( nameSpecialty == null ) {
            return null;
        }
        return nameSpecialty;
    }

    private Long reservationEntityBranchIdBranch(ReservationEntity reservationEntity) {
        if ( reservationEntity == null ) {
            return null;
        }
        BranchEntity branch = reservationEntity.getBranch();
        if ( branch == null ) {
            return null;
        }
        Long idBranch = branch.getIdBranch();
        if ( idBranch == null ) {
            return null;
        }
        return idBranch;
    }

    private String reservationEntityBranchName(ReservationEntity reservationEntity) {
        if ( reservationEntity == null ) {
            return null;
        }
        BranchEntity branch = reservationEntity.getBranch();
        if ( branch == null ) {
            return null;
        }
        String name = branch.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long reservationEntityAvailabilityIdAvailability(ReservationEntity reservationEntity) {
        if ( reservationEntity == null ) {
            return null;
        }
        AvailabilityEntity availability = reservationEntity.getAvailability();
        if ( availability == null ) {
            return null;
        }
        Long idAvailability = availability.getIdAvailability();
        if ( idAvailability == null ) {
            return null;
        }
        return idAvailability;
    }

    private LocalDate reservationEntityAvailabilityDate(ReservationEntity reservationEntity) {
        if ( reservationEntity == null ) {
            return null;
        }
        AvailabilityEntity availability = reservationEntity.getAvailability();
        if ( availability == null ) {
            return null;
        }
        LocalDate date = availability.getDate();
        if ( date == null ) {
            return null;
        }
        return date;
    }

    private LocalTime reservationEntityAvailabilityStartTime(ReservationEntity reservationEntity) {
        if ( reservationEntity == null ) {
            return null;
        }
        AvailabilityEntity availability = reservationEntity.getAvailability();
        if ( availability == null ) {
            return null;
        }
        LocalTime startTime = availability.getStartTime();
        if ( startTime == null ) {
            return null;
        }
        return startTime;
    }

    private LocalTime reservationEntityAvailabilityEndTime(ReservationEntity reservationEntity) {
        if ( reservationEntity == null ) {
            return null;
        }
        AvailabilityEntity availability = reservationEntity.getAvailability();
        if ( availability == null ) {
            return null;
        }
        LocalTime endTime = availability.getEndTime();
        if ( endTime == null ) {
            return null;
        }
        return endTime;
    }

    protected UserEntity reservationRequestDtoToUserEntity(ReservationRequestDto reservationRequestDto) {
        if ( reservationRequestDto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.idUser( reservationRequestDto.idPatient() );

        return userEntity.build();
    }

    protected UserEntity reservationRequestDtoToUserEntity1(ReservationRequestDto reservationRequestDto) {
        if ( reservationRequestDto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.idUser( reservationRequestDto.idDoctor() );

        return userEntity.build();
    }

    protected AvailabilityEntity reservationRequestDtoToAvailabilityEntity(ReservationRequestDto reservationRequestDto) {
        if ( reservationRequestDto == null ) {
            return null;
        }

        AvailabilityEntity.AvailabilityEntityBuilder availabilityEntity = AvailabilityEntity.builder();

        availabilityEntity.idAvailability( reservationRequestDto.idAvailability() );

        return availabilityEntity.build();
    }

    protected BranchEntity reservationRequestDtoToBranchEntity(ReservationRequestDto reservationRequestDto) {
        if ( reservationRequestDto == null ) {
            return null;
        }

        BranchEntity.BranchEntityBuilder branchEntity = BranchEntity.builder();

        branchEntity.idBranch( reservationRequestDto.idBranch() );

        return branchEntity.build();
    }
}
