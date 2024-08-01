package pi.demo.domain.sns.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pi.demo.domain.pet.dto.request.PetUpdateRequest;
import pi.demo.domain.test.entity.Test;
import pi.demo.global.entity.BaseTimeEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Sns extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="sns_id")
    private Long id;


    @Column(name="content")
    private String content;

    @Column(name="imageUrl")
    private String imageUrl;

    @Builder
    public Sns(String content, String imageUrl){
        this.content=content;
        this.imageUrl= imageUrl;
    }

}

