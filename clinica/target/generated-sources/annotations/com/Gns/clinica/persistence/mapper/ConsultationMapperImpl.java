package com.Gns.clinica.persistence.mapper;

import com.Gns.clinica.domain.dto.request.ConsultationRequestDto;
import com.Gns.clinica.domain.dto.response.ConsultationPublicResponseDto;
import com.Gns.clinica.domain.dto.response.ConsultationResponseDto;
import com.Gns.clinica.persistence.entity.ConsultationEntity;
import com.Gns.clinica.persistence.entity.ReservationEntity;
import com.Gns.clinica.persistence.entity.SpecialtyEntity;
import com.Gns.clinica.persistence.entity.UserEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-21T15:15:39-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Microsoft)"
)
@Component
public class ConsultationMapperImpl implements ConsultationMapper {

    @Override
    public ConsultationResponseDto toResponseDto(ConsultationEntity consultationEntity) {
        if ( consultationEntity == null ) {
            return null;
        }

        Long idConsultation = null;
        Long idReservation = null;
        Long idPatient = null;
        String namePatient = null;
        Long idDoctor = null;
        String nameDoctor = null;
        String nameSpecialty = null;
        LocalDate consultationDate = null;
        String reason = null;
        String diagnosis = null;
        String treatment = null;
        String notes = null;

        idConsultation = consultationEntity.getIdConsultation();
        idReservation = consultationEntityReservationIdReservation( consultationEntity );
        idPatient = consultationEntityPatientIdUser( consultationEntity );
        namePatient = consultationEntityPatientFirstName( consultationEntity );
        idDoctor = consultationEntityDoctorIdUser( consultationEntity );
        nameDoctor = consultationEntityDoctorFirstName( consultationEntity );
        nameSpecialty = consultationEntityDoctorSpecialtiesNameSpecialty( consultationEntity );
        consultationDate = consultationEntity.getConsultationDate();
        reason = consultationEntity.getReason();
        diagnosis = consultationEntity.getDiagnosis();
        treatment = consultationEntity.getTreatment();
        notes = consultationEntity.getNotes();

        ConsultationResponseDto consultationResponseDto = new ConsultationResponseDto( idConsultation, idReservation, idPatient, namePatient, idDoctor, nameDoctor, nameSpecialty, consultationDate, reason, diagnosis, treatment, notes );

        return consultationResponseDto;
    }

    @Override
    public List<ConsultationResponseDto> toResponseDto(List<ConsultationEntity> consultationEntityList) {
        if ( consultationEntityList == null ) {
            return null;
        }

        List<ConsultationResponseDto> list = new ArrayList<ConsultationResponseDto>( consultationEntityList.size() );
        for ( ConsultationEntity consultationEntity : consultationEntityList ) {
            list.add( toResponseDto( consultationEntity ) );
        }

        return list;
    }

    @Override
    public ConsultationPublicResponseDto toPublicResponseDto(ConsultationEntity consultationEntity) {
        if ( consultationEntity == null ) {
            return null;
        }

        Long idReservation = null;
        String namePatient = null;
        String nameDoctor = null;
        String nameSpecialty = null;
        LocalDate consultationDate = null;
        String reason = null;
        String diagnosis = null;
        String treatment = null;
        String notes = null;

        idReservation = consultationEntityReservationIdReservation( consultationEntity );
        namePatient = consultationEntityPatientFirstName( consultationEntity );
        nameDoctor = consultationEntityDoctorFirstName( consultationEntity );
        nameSpecialty = consultationEntityDoctorSpecialtiesNameSpecialty( consultationEntity );
        consultationDate = consultationEntity.getConsultationDate();
        reason = consultationEntity.getReason();
        diagnosis = consultationEntity.getDiagnosis();
        treatment = consultationEntity.getTreatment();
        notes = consultationEntity.getNotes();

        ConsultationPublicResponseDto consultationPublicResponseDto = new ConsultationPublicResponseDto( idReservation, namePatient, nameDoctor, nameSpecialty, consultationDate, reason, diagnosis, treatment, notes );

        return consultationPublicResponseDto;
    }

    @Override
    public List<ConsultationPublicResponseDto> toPublicResponseDto(List<ConsultationEntity> consultationEntityList) {
        if ( consultationEntityList == null ) {
            return null;
        }

        List<ConsultationPublicResponseDto> list = new ArrayList<ConsultationPublicResponseDto>( consultationEntityList.size() );
        for ( ConsultationEntity consultationEntity : consultationEntityList ) {
            list.add( toPublicResponseDto( consultationEntity ) );
        }

        return list;
    }

    @Override
    public ConsultationRequestDto toRequestDto(ConsultationEntity consultationEntity) {
        if ( consultationEntity == null ) {
            return null;
        }

        Long idReservation = null;
        Long idPatient = null;
        Long idDoctor = null;
        LocalDate consultationDate = null;
        String reason = null;
        String diagnosis = null;
        String treatment = null;
        String notes = null;

        idReservation = consultationEntityReservationIdReservation( consultationEntity );
        idPatient = consultationEntityPatientIdUser( consultationEntity );
        idDoctor = consultationEntityDoctorIdUser( consultationEntity );
        consultationDate = consultationEntity.getConsultationDate();
        reason = consultationEntity.getReason();
        diagnosis = consultationEntity.getDiagnosis();
        treatment = consultationEntity.getTreatment();
        notes = consultationEntity.getNotes();

        ConsultationRequestDto consultationRequestDto = new ConsultationRequestDto( idReservation, idPatient, idDoctor, consultationDate, reason, diagnosis, treatment, notes );

        return consultationRequestDto;
    }

    @Override
    public ConsultationEntity toEntity(ConsultationRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        ConsultationEntity.ConsultationEntityBuilder consultationEntity = ConsultationEntity.builder();

        consultationEntity.reservation( consultationRequestDtoToReservationEntity( requestDto ) );
        consultationEntity.patient( consultationRequestDtoToUserEntity( requestDto ) );
        consultationEntity.doctor( consultationRequestDtoToUserEntity1( requestDto ) );
        consultationEntity.consultationDate( requestDto.consultationDate() );
        consultationEntity.reason( requestDto.reason() );
        consultationEntity.diagnosis( requestDto.diagnosis() );
        consultationEntity.treatment( requestDto.treatment() );
        consultationEntity.notes( requestDto.notes() );

        return consultationEntity.build();
    }

    private Long consultationEntityReservationIdReservation(ConsultationEntity consultationEntity) {
        if ( consultationEntity == null ) {
            return null;
        }
        ReservationEntity reservation = consultationEntity.getReservation();
        if ( reservation == null ) {
            return null;
        }
        Long idReservation = reservation.getIdReservation();
        if ( idReservation == null ) {
            return null;
        }
        return idReservation;
    }

    private Long consultationEntityPatientIdUser(ConsultationEntity consultationEntity) {
        if ( consultationEntity == null ) {
            return null;
        }
        UserEntity patient = consultationEntity.getPatient();
        if ( patient == null ) {
            return null;
        }
        Long idUser = patient.getIdUser();
        if ( idUser == null ) {
            return null;
        }
        return idUser;
    }

    private String consultationEntityPatientFirstName(ConsultationEntity consultationEntity) {
        if ( consultationEntity == null ) {
            return null;
        }
        UserEntity patient = consultationEntity.getPatient();
        if ( patient == null ) {
            return null;
        }
        String firstName = patient.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private Long consultationEntityDoctorIdUser(ConsultationEntity consultationEntity) {
        if ( consultationEntity == null ) {
            return null;
        }
        UserEntity doctor = consultationEntity.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        Long idUser = doctor.getIdUser();
        if ( idUser == null ) {
            return null;
        }
        return idUser;
    }

    private String consultationEntityDoctorFirstName(ConsultationEntity consultationEntity) {
        if ( consultationEntity == null ) {
            return null;
        }
        UserEntity doctor = consultationEntity.getDoctor();
        if ( doctor == null ) {
            return null;
        }
        String firstName = doctor.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String consultationEntityDoctorSpecialtiesNameSpecialty(ConsultationEntity consultationEntity) {
        if ( consultationEntity == null ) {
            return null;
        }
        UserEntity doctor = consultationEntity.getDoctor();
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

    protected ReservationEntity consultationRequestDtoToReservationEntity(ConsultationRequestDto consultationRequestDto) {
        if ( consultationRequestDto == null ) {
            return null;
        }

        ReservationEntity.ReservationEntityBuilder reservationEntity = ReservationEntity.builder();

        reservationEntity.idReservation( consultationRequestDto.idReservation() );

        return reservationEntity.build();
    }

    protected UserEntity consultationRequestDtoToUserEntity(ConsultationRequestDto consultationRequestDto) {
        if ( consultationRequestDto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.idUser( consultationRequestDto.idPatient() );

        return userEntity.build();
    }

    protected UserEntity consultationRequestDtoToUserEntity1(ConsultationRequestDto consultationRequestDto) {
        if ( consultationRequestDto == null ) {
            return null;
        }

        UserEntity.UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.idUser( consultationRequestDto.idDoctor() );

        return userEntity.build();
    }
}
