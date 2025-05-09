package com.example.CureMap.dto.vitals;

import com.example.CureMap.domain.Vitals;
import lombok.Getter;

@Getter
public class VitalsResponseDto {

    private Long    id;
    private Long    patientId;
    private Double  temperature;      // 체온
    private Integer heartRate;        // 맥박
    private Integer respiratoryRate;  // 호흡수
    private Integer systolicBP;       // 수축기 혈압
    private Integer diastolicBP;      // 이완기 혈압

    public VitalsResponseDto(Vitals v) {
        this.id             = v.getId();
        this.patientId      = v.getPatient().getId();
        this.temperature    = v.getTemperature();
        this.heartRate      = v.getHeartRate();
        this.respiratoryRate= v.getRespiratoryRate();
        this.systolicBP     = v.getSystolicBP();
        this.diastolicBP    = v.getDiastolicBP();
    }
}
