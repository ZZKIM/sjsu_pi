package pi.demo.domain.pet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pi.demo.domain.pet.dto.request.PetSaveRequest;
import pi.demo.domain.pet.dto.request.PetUpdateRequest;
import pi.demo.domain.pet.dto.response.PetGetResponse;
import pi.demo.domain.pet.entity.Pet;
import pi.demo.domain.pet.repository.PetRepository;

import java.io.IOException;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class PetService {
    private final PetRepository petRepository;
    @Transactional
    public Long registerPetInfo(PetSaveRequest petSaveRequest)throws IOException {
        Pet pet = Pet.builder()
                .name(petSaveRequest.name())
                .weight(petSaveRequest.weight())
                .age(petSaveRequest.age())
                .gender(petSaveRequest.gender())
                .build();
        petRepository.save(pet);

        return pet.getId();
    }
    public Long updatePetInfo(PetUpdateRequest petUpdateRequest, Long petId)throws IOException{
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new NoSuchElementException("해당 pet이 없습니다"));

        pet.updatePet(petUpdateRequest);

        petRepository.save(pet);

        return pet.getId();
    }
    public PetGetResponse getPetInfo(Long petId)throws IOException{
        Pet pet = petRepository.findById(petId)
                .orElseThrow(() -> new NoSuchElementException("해당 pet이 없습니다"));

        return PetGetResponse.builder()
                .petId(pet.getId())
                .name(pet.getName())
                .weight(pet.getWeight())
                .age(pet.getAge())
                .gender(pet.getGender())
                .build();
    }

}
