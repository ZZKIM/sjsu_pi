package pi.demo.domain.test.dto.response;

import lombok.Builder;
import pi.demo.domain.geneResult.entity.GeneResult;

import java.time.LocalDate;
import java.util.List;

@Builder
public record TestResponse(Long test_id, LocalDate testDate, List<GeneResult> geneResults) {
}
