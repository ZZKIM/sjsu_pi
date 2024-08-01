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
@Tag(name = "Pet", description = "APIs related to pets")
@RequiredArgsConstructor
@Slf4j
public class PetController {
    private final PetService petService;

    @PostMapping("/register")
    @Operation(summary = "Register Pet", description = "Register a new pet")
    public ResponseEntity<ApiUtil.ApiSuccessResult<Long>> registerPet(
            @RequestPart(value = "PetSaveRequest") PetSaveRequest petSaveRequest) throws IOException {

        Long saveId = petService.registerPetInfo(petSaveRequest);

        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.CREATED, saveId));
    }

    @PutMapping("/update/{petId}")
    @Operation(summary = "Update Pet Info", description = "Update pet information")
    public ResponseEntity<ApiUtil.ApiSuccessResult<Long>> updatePet(
            @PathVariable("petId") Long petId,
            @RequestPart(value = "PetUpdateRequest") PetUpdateRequest petUpdateRequest
    ) throws IOException {

        Long updateId = petService.updatePetInfo(petUpdateRequest, petId);

        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.CREATED, updateId));
    }

    @GetMapping("/view/{petId}")
    @Operation(summary = "View Pet", description = "View pet information")
    public ResponseEntity<ApiUtil.ApiSuccessResult<PetGetResponse>> viewPet(
            @PathVariable("petId") Long petId) throws IOException {

        PetGetResponse petGetResponse = petService.getPetInfo(petId);

        return ResponseEntity.ok().body(ApiUtil.success(HttpStatus.CREATED, petGetResponse));
    }
}
