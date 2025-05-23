package com.example.CureMap.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long id;

    private String hospitalId;
    private String gender;

    @Column(name = "recent_hospitalized")
    private Boolean recentlyHospitalized;

    @Enumerated(EnumType.STRING)
    private AgeGroup ageGroup;

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private List<UnderlyingDisease> underlyingDiseases;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LabResult> labResults = new ArrayList<>();

    // Patient.java
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AntibioticHistory> antibioticHistories = new HashSet<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CurrentMedication> currentMedications = new HashSet<>();


}
