package com.example.CureMap.repository;

import com.example.CureMap.domain.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecommendRepository extends JpaRepository<Recommend, Long> {
    Optional<Recommend> findByPatientId(Long patientId);
}
