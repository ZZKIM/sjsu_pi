package pi.demo.domain.pet.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pi.demo.domain.geneTest.entity.GeneTest;
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
    private Long age;

    @Column(name = "gender")
    private String gender;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private List<GeneTest> genericTests = new ArrayList<>();


    @Builder
    public Pet(String name, Double weight, Long age, String gender){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.gender = gender;
    }
}
