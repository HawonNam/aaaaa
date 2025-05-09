package com.example.CureMap.dto.labResult;
import com.example.CureMap.domain.LabResult;
import lombok.Builder;
import lombok.Getter;


@Getter
public class LabResultResponseDto {

    private Long patientId;
    private String specimenName;         // 검체명 (예: 소변, 혈액)
    private String mainTestName;         // 검사명 (예: 요검사, 혈액 검사)
    private String mainTestResult;       // 수치결과내용 (예: WBC 15,000)
    private String subTestName;          // 부검사명 (예: Protein)
    private String subTestResult;        // 부검사 결과내용 (예: Negative)

    // 엔티티→DTO 변환용 생성자
    public LabResultResponseDto(LabResult entity) {
        this.patientId      = entity.getPatient().getId();
        this.specimenName   = entity.getSpecimenName();
        this.mainTestName   = entity.getMainTestName();
        this.mainTestResult = entity.getMainTestResult();     // ← 여기가 잘못되어 있었음
        this.subTestName    = entity.getSubTestName();
        this.subTestResult  = entity.getSubTestResult();
    }

    @Builder
    public LabResultResponseDto(Long patientId,
                                String specimenName,
                                String mainTestName,
                                String mainTestResult,
                                String subTestName,
                                String subTestResult) {
        this.patientId      = patientId;
        this.specimenName   = specimenName;     // ← specimenName ←
        this.mainTestName   = mainTestName;
        this.mainTestResult = mainTestResult;
        this.subTestName    = subTestName;
        this.subTestResult  = subTestResult;
    }

}
