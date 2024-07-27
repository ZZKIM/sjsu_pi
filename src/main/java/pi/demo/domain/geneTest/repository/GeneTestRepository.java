package pi.demo.domain.geneTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pi.demo.domain.geneTest.entity.GeneTest;

public interface GeneTestRepository extends JpaRepository<GeneTest, Long> {

    GeneTest findByGeneTestId(Long testId);
}
