package pi.demo.domain.geneResult.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pi.demo.domain.geneResult.entity.GeneResult;
import pi.demo.domain.geneResult.repository.GeneResultRepository;
import pi.demo.domain.test.entity.Test;
import pi.demo.domain.test.repository.TestRepository;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GeneResultService {

    private final TestRepository geneTestRepository;
    private final GeneResultRepository geneResultRepository;
    public List<GeneResult> registerGeneResult(Test geneTest, List<GeneResult> geneResults) throws IOException {

        for (GeneResult result : geneResults) {
            result.setTest(geneTest);
        }

        geneTest.addGeneResults(geneResults);

        geneTestRepository.save(geneTest);

        return geneResults;
    }

    public List<GeneResult> getGeneResults (Long geneTestId)
    {
       // Test test = geneTestRepository.findById(geneTestId).orElseThrow();
        List<GeneResult> geneResults = geneResultRepository.findByTest_Id(geneTestId);

        return geneResults;
    }

}
