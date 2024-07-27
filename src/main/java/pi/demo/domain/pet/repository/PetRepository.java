package pi.demo.domain.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pi.demo.domain.pet.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

    Pet findPetByPetId(Long petId);
}