package pi.demo.domain.geneResult.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pi.demo.domain.test.entity.Test;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GeneResult{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="geneResult_id")
    private Long id;

    @Column(name = "disease")
    private String disease;

    @Column(name = "explanation")
    private String explanation;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id", nullable = false)
    private Test test;

    public GeneResult(String disease, String explanation, Status status, Test geneTest){
        this.disease = disease;
        this.explanation = explanation;
        this.status = status;
        this.test = geneTest;
    }



}
