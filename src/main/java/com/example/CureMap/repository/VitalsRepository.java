package com.example.CureMap.repository;

import com.example.CureMap.domain.Patient;
import com.example.CureMap.domain.Vitals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VitalsRepository extends JpaRepository<Vitals, Long> {
    List<Vitals> findAllByPatient(Patient patient);
}
