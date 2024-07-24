package pi.demo.domain.insurance.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pi.demo.domain.coverage.entity.Coverage;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="generic_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "company")
    private String company;

    @OneToMany(mappedBy = "insurace", cascade = CascadeType.ALL)
    private List<Coverage> coverages = new ArrayList<>();


    public Insurance(String name, String company){
        this.name = name;
        this.company = company;
    }

}
