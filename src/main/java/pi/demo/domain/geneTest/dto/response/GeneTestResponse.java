package pi.demo.domain.geneTest.dto.response;

import lombok.Builder;
import pi.demo.domain.geneResult.entity.GeneResult;
import pi.demo.domain.pet.entity.Pet;

import java.time.LocalDate;
import java.util.List;

@Builder
public record GeneTestResponse(Long test_id, LocalDate testDate, List<GeneResult> geneResults) {
}
