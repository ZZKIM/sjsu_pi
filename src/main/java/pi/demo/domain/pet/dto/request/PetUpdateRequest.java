package pi.demo.domain.pet.dto.request;

import lombok.Builder;

@Builder
public record PetUpdateRequest(String name, Double weight, int age, String gender){
}
