package pi.demo.domain.test.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pi.demo.domain.geneResult.entity.GeneResult;
import pi.demo.domain.pet.entity.Pet;
import pi.demo.global.entity.BaseTimeEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Test extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="test_id")
    private Long id;

    @Column(name = "test_date")
    private LocalDate testDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id", nullable = true)
    private Pet pet;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<GeneResult> geneResults = new ArrayList<>();

    @Builder
    public Test(Pet pet, LocalDate testDate){
        this.pet = pet;
        this.testDate = testDate;
    }

    public void addGeneResults(List<GeneResult> results) {
        for (GeneResult result : results) {
            result.setTest(this);
        }
        this.geneResults.addAll(results);
    }



}
