package com.example.CureMap.dto.patient;

import com.example.CureMap.domain.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Getter

@AllArgsConstructor
public class PatientResponseDto {
    private Long id;
    private String hospitalId;
    private AgeGroup ageGroup;
    private String gender;
    private List<UnderlyingDisease> underlyingDiseases;
    private Boolean recentlyHospitalized;
    private List<String> antibioticHistories;
    private List<String> currentMedications;


    @Builder
    public PatientResponseDto(Patient patient) {
        this.id = patient.getId();
        this.hospitalId = patient.getHospitalId();
        this.ageGroup = patient.getAgeGroup();
        this.gender = patient.getGender();
        this.underlyingDiseases = patient.getUnderlyingDiseases();
        this.recentlyHospitalized = patient.getRecentlyHospitalized();
        this.antibioticHistories = patient.getAntibioticHistories()
                .stream()
                .map(AntibioticHistory::getAntibioticName)
                .toList();
        this.currentMedications = patient.getCurrentMedications()
                .stream()
                .map(CurrentMedication::getMedicationName)
                .toList();
    }
}

