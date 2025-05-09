package com.example.CureMap.service;

import com.example.CureMap.domain.LabResult;
import com.example.CureMap.domain.Patient;
import com.example.CureMap.dto.labResult.LabResultRequestDto;
import com.example.CureMap.dto.labResult.LabResultResponseDto;
import com.example.CureMap.repository.LabResultRepository;
import com.example.CureMap.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LabResultService {
    private final LabResultRepository labResultRepository;
    private final PatientRepository patientRepository;

    public LabResultResponseDto createLabResult(LabResultRequestDto dto) {
        Patient patient = patientRepository.findById(dto.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID"));

        LabResult labResult = LabResult.builder()
                .patient(patient)
                .specimenName(dto.getSpecimenName())
                .mainTestName(dto.getMainTestName())
                .mainTestResult(dto.getMainTestResult())
                .subTestName(dto.getSubTestName())
                .subTestResult(dto.getSubTestResult())
                .build();

        LabResult saved = labResultRepository.save(labResult);

        return LabResultResponseDto.builder()
                .patientId(saved.getPatient().getId())
                .specimenName(saved.getSpecimenName())
                .mainTestName(saved.getMainTestName())
                .mainTestResult(saved.getMainTestResult())
                .subTestName(saved.getSubTestName())
                .subTestResult(saved.getSubTestResult())
                .build();
    }
    @Transactional(readOnly = true)
    public List<LabResultResponseDto> getLabResultsByPatientId(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID"));

        return labResultRepository
                .findAllByPatient(patient)
                .stream()
                .map(LabResultResponseDto::new)
                .toList();
    }

}
