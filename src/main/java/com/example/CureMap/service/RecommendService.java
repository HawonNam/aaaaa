package com.example.CureMap.service;

import com.example.CureMap.domain.Recommend;
import com.example.CureMap.dto.recommend.RecommendResponseDto;
import com.example.CureMap.repository.RecommendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RecommendService {
    private final RecommendRepository repository;

    @Transactional(readOnly = true)
    public RecommendResponseDto getForPatient(Long patientId){
        Recommend recommend = repository.findByPatientId(patientId)
                .orElseThrow(() -> new IllegalArgumentException("추천 결과가 없습니다."));
        return new RecommendResponseDto(recommend);
    }
}
