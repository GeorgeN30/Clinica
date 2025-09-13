package com.Gns.clinica.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "specialties")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecialtyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_specialty")
    private Long idSpecialty;

    @Column(name = "name_specialty", unique = true)
    private String nameSpecialty;


}
