package com.Gns.clinica.persistence.entity;

import com.Gns.clinica.domain.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private Long idReservation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_patient")
    private UserEntity patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_doctor")
    private UserEntity doctor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_specialty")
    private SpecialtyEntity specialty;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_branch")
    private BranchEntity branch;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_availability")
    private AvailabilityEntity availability;

    private LocalDate reservationDate;
    private LocalTime reservationTime;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
}
