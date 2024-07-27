package pi.demo.domain.geneTest.service;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pi.demo.domain.geneResult.entity.GeneResult;
import pi.demo.domain.geneResult.service.GeneResultService;
import pi.demo.domain.geneTest.dto.request.GeneTestSaveRequest;
import pi.demo.domain.geneTest.dto.response.GeneTestResponse;
import pi.demo.domain.geneTest.entity.GeneTest;
import pi.demo.domain.geneTest.repository.GeneTestRepository;
import pi.demo.domain.pet.entity.Pet;
import pi.demo.domain.pet.repository.PetRepository;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class GeneTestService {

    private final GeneTestRepository geneTestRepository;

    private final PetRepository petRepository;
    private final GeneTestService geneTestService;
    private final GeneResultService geneResultService;

    public Long registerGeneTest(GeneTestSaveRequest geneTestSaveRequest, List<GeneResult> geneResults)throws IOException{

        GeneTest geneTest = GeneTest.builder()
                .pet(petRepository.findPetByPetId(geneTestSaveRequest.petId()))
                .testDate(geneTestSaveRequest.testDate())
                .pet(petRepository.findPetByPetId(geneTestSaveRequest.petId()))
                .build();

        geneResultService.registerGeneResult(geneTest, geneResults);

        geneTestRepository.save(geneTest);

        return geneTest.getId();
    }


    public GeneTestResponse viewGeneTest(Long testId)throws IOException{

        GeneTest geneTest = geneTestRepository.findByGeneTestId(testId);

        List<GeneResult> geneResults = geneResultService.getGeneResults(testId);

        return GeneTestResponse.builder()
                .test_id(geneTest.getId())
                .testDate(geneTest.getTestDate())
                .geneResults(geneResults)
                .build();

    }
}
