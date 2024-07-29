package pi.demo.domain.pet.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pi.demo.domain.test.entity.Test;
import pi.demo.domain.pet.dto.request.PetUpdateRequest;
import pi.demo.global.entity.BaseTimeEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Pet extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="pet_id")
    private Long id;

    @Column(name = "pet_name")
    private String name;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private List<Test> genericTests = new ArrayList<>();


    @Builder
    public Pet(String name, Double weight, int age, String gender){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
    }

    public void updatePet(PetUpdateRequest petUpdateRequest){
        this.name = petUpdateRequest.name();
        this.weight = petUpdateRequest.weight();
        this.age = petUpdateRequest.age();
        this.gender = petUpdateRequest.gender();
    }
}
