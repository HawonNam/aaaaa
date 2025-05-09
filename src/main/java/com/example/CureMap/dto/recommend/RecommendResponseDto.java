package com.example.CureMap.dto.recommend;

import com.example.CureMap.domain.Recommend;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RecommendResponseDto {
    private Long patientId;
    private String bestAntibiotic;
    private String niceAntibiotic;

    public RecommendResponseDto(Recommend entity) {
        this.patientId       = entity.getPatient().getId();
        this.bestAntibiotic  = entity.getBestAntibiotic();
        this.niceAntibiotic  = entity.getNiceAntibiotic();
    }
}
