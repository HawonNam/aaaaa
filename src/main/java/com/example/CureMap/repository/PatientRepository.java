package com.example.CureMap.repository;

import com.example.CureMap.domain.Patient;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @EntityGraph(
            attributePaths = {"antibioticHistories", "currentMedications"}
    )
    Optional<Patient> findWithDetailsById(Long id);
}
