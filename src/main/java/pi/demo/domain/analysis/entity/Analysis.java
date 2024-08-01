package pi.demo.domain.analysis.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pi.demo.global.entity.BaseTimeEntity;

@Entity
@Getter
@NoArgsConstructor
public class Analysis extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="analysis_id")
    private Long id;


    @Column(name="content")
    private String content;

    @Column(name="imageUrl")
    private String imageUrl;

    @Builder
    public Analysis(String content, String imageUrl){
        this.content=content;
        this.imageUrl= imageUrl;
    }

}

