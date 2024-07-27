package pi.demo.domain.geneResult.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pi.demo.domain.geneResult.entity.GeneResult;
import pi.demo.domain.geneResult.repository.GeneResultRepository;
import pi.demo.domain.geneTest.entity.GeneTest;
import pi.demo.domain.geneTest.repository.GeneTestRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GeneResultService {

    private final GeneTestRepository geneTestRepository;
    private final GeneResultRepository geneResultRepository;
    public List<GeneResult> registerGeneResult(GeneTest geneTest, List<GeneResult> geneResults) throws IOException {

        for (GeneResult result : geneResults) {
            result.setGeneTest(geneTest);
        }

        geneTest.addGeneResults(geneResults);

        geneTestRepository.save(geneTest);

        return geneResults;
    }

    public List<GeneResult> getGeneResults (Long geneTestId)
    {
        List<GeneResult> geneResults = geneResultRepository.findByGeneTestId(geneTestId);

        return geneResults;
    }

}
