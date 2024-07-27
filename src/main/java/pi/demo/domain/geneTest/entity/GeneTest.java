package pi.demo.domain.geneTest.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pi.demo.domain.geneResult.entity.GeneResult;
import pi.demo.domain.pet.entity.Pet;
import pi.demo.global.entity.BaseTimeEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class GeneTest extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="genetest_id")
    private Long id;

    @Column(name = "test_date")
    private LocalDate testDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id", nullable = true)
    private Pet pet;

    @OneToMany(mappedBy = "genericTest", cascade = CascadeType.ALL)
    private List<GeneResult> geneResults = new ArrayList<>();

    @Builder
    public GeneTest(Pet pet, LocalDate testDate){
        this.pet = pet;
        this.testDate = testDate;
    }

    public void addGeneResults(List<GeneResult> results) {
        for (GeneResult result : results) {
            result.setGeneTest(this);
        }
        this.geneResults.addAll(results);
    }



}
