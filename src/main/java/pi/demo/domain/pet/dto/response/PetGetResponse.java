package pi.demo.domain.pet.dto.response;

import lombok.Builder;

@Builder
public record PetGetResponse(Long petId, String name, Double weight, int age, String gender) {
}
