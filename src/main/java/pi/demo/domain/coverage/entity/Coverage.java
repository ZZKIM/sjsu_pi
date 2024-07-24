package pi.demo.domain.coverage.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pi.demo.domain.geneResult.entity.GeneResult;
import pi.demo.domain.geneTest.entity.GeneTest;
import pi.demo.domain.insurance.entity.Insurance;
import pi.demo.global.entity.BaseTimeEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Coverage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="coverage_id")
    private Long id;

    @Column(name = "coverage_name")
    private String name;

    @Column(name = "dollar")
    private Long dollar;

    @Column(name = "period")
    private Long period;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "insurance", nullable = false)
    private Insurance insurance;

    @Builder
    public Coverage(String name, Long dollar, Long period, Insurance insurace){
        this.name = name;
        this.dollar = dollar;
        this.period = period;
        this.insurance = insurace;
    }
}
