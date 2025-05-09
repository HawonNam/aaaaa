package com.example.CureMap.repository;

import com.example.CureMap.domain.LabResult;
import com.example.CureMap.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LabResultRepository extends JpaRepository<LabResult, Long> {
    List<LabResult> findAllByPatient(Patient patient);
}
