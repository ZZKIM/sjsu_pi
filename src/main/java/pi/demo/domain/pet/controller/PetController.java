package pi.demo.domain.pet.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pi.demo.domain.pet.dto.request.PetSaveRequest;
import pi.demo.domain.pet.dto.request.PetUpdateRequest;
import pi.demo.domain.pet.dto.response.PetGetResponse;
import pi.demo.domain.pet.service.PetService;
import pi.demo.global.util.ApiUtil;

import java.io.IOException;


@RestController
@RequestMapping("/pet")
@Tag(name = "게시글", description = "게시글 관련 Api")
@RequiredArgsConstructor
@Slf4j
public class PetController {
    private final PetService petService;

    @PostMapping("/register")
    @Operation(summary = "펫 등록", description = "펫 등록하는 로직")
    public ResponseEntity<ApiUtil.ApiSuccessResult<Long>> registerPet(
            HttpServletRequest request,
            @RequestPart(value="PetSaveRequest") PetSaveRequest petSaveRequest) throws IOException {

        Long saveId = petService.registerPetInfo(petSaveRequest);

        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.CREATED,saveId));
    }

    @PutMapping("/update/{petId}")
    @Operation(summary = "update Pet Info", description = "펫 정보 업데이트하는 로직")
    public ResponseEntity<ApiUtil.ApiSuccessResult<Long>> viewPet(
            @PathVariable("petId") Long petId,
            @RequestPart(value="PetUpdateRequest") PetUpdateRequest petUpdateRequest
            ) throws IOException {

        Long updateId = petService.updatePetInfo(petUpdateRequest,petId);

        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.CREATED,updateId));
    }


    @GetMapping("/view/{petId}")
    @Operation(summary = "view Pet", description = "펫 정보 보는 로직")
    public ResponseEntity<ApiUtil.ApiSuccessResult<PetGetResponse>> viewPet(
            @PathVariable("petId") Long petId) throws IOException {

        PetGetResponse petGetResponse = petService.getPetInfo(petId);

        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.CREATED,petGetResponse));
    }


}
