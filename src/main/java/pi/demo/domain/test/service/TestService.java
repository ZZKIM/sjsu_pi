package pi.demo.domain.test.service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pi.demo.domain.geneResult.entity.GeneResult;
import pi.demo.domain.geneResult.service.GeneResultService;
import pi.demo.domain.test.dto.request.TestSaveRequest;
import pi.demo.domain.test.dto.response.TestResponse;
import pi.demo.domain.test.entity.Test;
import pi.demo.domain.test.repository.TestRepository;
import pi.demo.domain.pet.repository.PetRepository;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TestService {

    private final TestRepository geneTestRepository;
    private final PetRepository petRepository;
    private final GeneResultService geneResultService;

    public Long registerGeneTest(TestSaveRequest geneTestSaveRequest, List<GeneResult> geneResults)throws IOException{

        Test geneTest = Test.builder()
                .pet(petRepository.findPetById(geneTestSaveRequest.petId()))
                .testDate(geneTestSaveRequest.testDate())
                .pet(petRepository.findPetById(geneTestSaveRequest.petId()))
                .build();

        geneResultService.registerGeneResult(geneTest, geneResults);

        geneTestRepository.save(geneTest);

        return geneTest.getId();
    }


    public TestResponse viewGeneTest(Long testId)throws IOException{

        Test geneTest = geneTestRepository.findById(testId)
                .orElseThrow(() -> new EntityNotFoundException("Test not found with id: " + testId));

        List<GeneResult> geneResults = geneResultService.getGeneResults(testId);

        return TestResponse.builder()
                .test_id(geneTest.getId())
                .testDate(geneTest.getTestDate())
                .geneResults(geneResults)
                .build();

    }
}
