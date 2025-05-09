package com.example.CureMap.service;

import com.example.CureMap.domain.Patient;
import com.example.CureMap.domain.Vitals;
import com.example.CureMap.dto.vitals.VitalsRequestDto;
import com.example.CureMap.dto.vitals.VitalsResponseDto;
import com.example.CureMap.repository.PatientRepository;
import com.example.CureMap.repository.VitalsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VitalService {
    private final VitalsRepository vitalsRepository;
    private final PatientRepository patientRepository;

    public VitalsResponseDto saveVitals(VitalsRequestDto dto) {
        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("환자를 찾을 수 없습니다."));

        Vitals vitals = Vitals.builder()
                .patient(patient)
                .heartRate(dto.getHeartRate())
                .respiratoryRate(dto.getRespiratoryRate())
                .temperature(dto.getTemperature())
                .systolicBP(dto.getSystolicBP())
                .diastolicBP(dto.getDiastolicBP())
                .build();

        Vitals saved = vitalsRepository.save(vitals);
        return new VitalsResponseDto(saved);
    }

    @Transactional(readOnly = true)
    public List<VitalsResponseDto> getVitalsByPatientId(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID"));
        return vitalsRepository.findAllByPatient(patient)
                .stream()
                .map(VitalsResponseDto::new)
                .toList();
    }
}
