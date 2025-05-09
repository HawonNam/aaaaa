package com.example.CureMap.controller;

import com.example.CureMap.dto.recommend.RecommendResponseDto;
import com.example.CureMap.service.RecommendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/patients/{id}/recommend")
public class RecommendController {
    private final RecommendService recommendService;

    @GetMapping
    public ResponseEntity<RecommendResponseDto> getRecommend(@PathVariable("id") Long patientId){
        RecommendResponseDto dto = recommendService.getForPatient(patientId);
        return ResponseEntity.ok(dto);
    }
}
