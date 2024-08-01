package pi.demo.domain.analysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pi.demo.domain.analysis.entity.Analysis;

public interface AnalysisRepository extends JpaRepository<Analysis, Long> {
}
