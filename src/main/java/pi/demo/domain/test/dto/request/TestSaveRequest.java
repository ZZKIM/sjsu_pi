package pi.demo.domain.test.dto.request;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record TestSaveRequest(Long petId, LocalDate testDate) {
}
