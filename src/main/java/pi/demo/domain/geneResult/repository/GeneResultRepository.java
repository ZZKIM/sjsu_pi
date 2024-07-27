package pi.demo.domain.geneResult.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pi.demo.domain.geneResult.entity.GeneResult;
import pi.demo.domain.geneTest.entity.GeneTest;

import java.util.List;

public interface GeneResultRepository extends JpaRepository<GeneTest, Long> {

    List<GeneResult> findByGeneTestId(Long testId);
}
