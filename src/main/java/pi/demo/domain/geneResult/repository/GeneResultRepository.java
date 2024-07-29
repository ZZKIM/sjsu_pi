package pi.demo.domain.geneResult.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pi.demo.domain.geneResult.entity.GeneResult;

import java.util.List;

@EnableJpaRepositories
public interface GeneResultRepository extends JpaRepository<GeneResult, Long> {

    List<GeneResult> findByTest_Id(Long testId);
}
