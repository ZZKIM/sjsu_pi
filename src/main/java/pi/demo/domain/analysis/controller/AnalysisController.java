package pi.demo.domain.analysis.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.demo.domain.analysis.dto.request.AnalysisSaveRequest;
import pi.demo.domain.analysis.dto.response.AnalysisAllReadResponse;
import pi.demo.domain.analysis.service.AnalysisService;
import pi.demo.global.util.ApiUtil;

import java.io.IOException;
import java.util.List;

@RestController
@Tag(name = "Analysis", description = "APIs related to AI-based behavioral analysis of pets")
@RequestMapping("/analysis")
@RequiredArgsConstructor
public class AnalysisController {
    private final AnalysisService analysisService;

    @PostMapping("/register")
    @Operation(summary = "Add Analysis", description = "Endpoint to add a new analysis entry based on AI behavioral analysis of pets. Accepts an AnalysisSaveRequest object as input and returns the ID of the newly created entry.")
    public ResponseEntity<ApiUtil.ApiSuccessResult<Long>> createAnalysis(
            @RequestPart(value = "AnalysisSaveRequest") AnalysisSaveRequest analysisSaveRequest) throws IOException {

        Long saveId = analysisService.registerAnalysis(analysisSaveRequest);
        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.CREATED, saveId));
    }

    @GetMapping()
    @Operation(summary = "Get all Analyses", description = "Endpoint to retrieve all analysis entries. Returns a list of AnalysisAllReadResponse objects representing all analyses in the system.")
    public ResponseEntity<ApiUtil.ApiSuccessResult<List<AnalysisAllReadResponse>>> readAllAnalyses() throws IOException {
        List<AnalysisAllReadResponse> allAnalyses = analysisService.findAllAnalysis();
        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.OK, allAnalyses));
    }
}
