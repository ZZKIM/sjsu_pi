package pi.demo.domain.sns.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.demo.domain.sns.dto.request.SnsSaveRequest;
import pi.demo.domain.sns.dto.response.SnsAllReadResponse;
import pi.demo.domain.sns.service.SnsService;
import pi.demo.global.util.ApiUtil;

import java.io.IOException;
import java.util.List;

@RestController
@Tag(name = "SNS", description = "APIs related to SNS operations")
@RequestMapping("/sns")
@RequiredArgsConstructor
public class SnsController {
    private final SnsService snsService;

    @PostMapping("/register")
    @Operation(summary = "Add SNS", description = "Endpoint to add a new SNS entry. Accepts an SNSSaveRequest object as input and returns the ID of the newly created entry.")
    public ResponseEntity<ApiUtil.ApiSuccessResult<Long>> createSns(
            @RequestPart(value = "SnsSaveRequest") SnsSaveRequest snsSaveRequest) throws IOException {

        Long saveId = snsService.registerSns(snsSaveRequest);
        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.CREATED, saveId));
    }

    @GetMapping()
    @Operation(summary = "Get all SNS entries", description = "Endpoint to retrieve all SNS entries. Returns a list of SnsAllReadResponse objects representing all SNS entries in the system.")
    public ResponseEntity<ApiUtil.ApiSuccessResult<List<SnsAllReadResponse>>> readAllSns() throws IOException {
        List<SnsAllReadResponse> allSns = snsService.findAllSns();
        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.OK, allSns));
    }
}
