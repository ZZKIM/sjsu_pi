package pi.demo.domain.geneTest.dto.request;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record GeneTestSaveRequest(Long petId, LocalDate testDate) {
}
