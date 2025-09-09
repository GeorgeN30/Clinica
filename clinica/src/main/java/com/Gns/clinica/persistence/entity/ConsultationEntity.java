package com.Gns.clinica.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "consultations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConsultationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consultation")
    private Long idConsultation;

    @OneToOne
    @JoinColumn(name = "id_reservation", unique = true)
    private ReservationEntity reservation;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_patient")
    private UserEntity patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_doctor")
    private UserEntity doctor;

    private LocalDate consultationDate;
    private String reason;
    private String diagnosis;
    private String treatment;
    private String notes;

}
