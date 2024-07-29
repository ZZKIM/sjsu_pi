package pi.demo.domain.test.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.demo.domain.geneResult.entity.GeneResult;
import pi.demo.domain.test.dto.request.TestSaveRequest;
import pi.demo.domain.test.dto.response.TestResponse;
import pi.demo.domain.test.service.TestService;
import pi.demo.global.util.ApiUtil;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/gene-test")
@Tag(name = "유전자 검사", description = "유전자 검사 관련 Api")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final TestService geneTestService;

    @PostMapping("/register")
    @Operation(summary = "register test Info", description = "펫 유전자 검사 결과 등록하는 로직")
    public ResponseEntity<ApiUtil.ApiSuccessResult<Long>> registerGeneTest(
            @RequestBody TestSaveRequest geneTestSaveRequest,
            @RequestBody List<GeneResult> geneResults) throws IOException {

        Long saveId = geneTestService.registerGeneTest(geneTestSaveRequest, geneResults);

        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.CREATED, saveId));
    }

    @GetMapping("/view/{testId}")
    @Operation(summary = "view test Info", description = "펫 유전자 검사 결과를 확인하는 로직")
    public ResponseEntity<ApiUtil.ApiSuccessResult<TestResponse>> viewGeneTest(
            @PathVariable("testId") Long testId) throws IOException {

        TestResponse geneTestResponse = geneTestService.viewGeneTest(testId);

        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.CREATED,geneTestResponse));
    }
}
