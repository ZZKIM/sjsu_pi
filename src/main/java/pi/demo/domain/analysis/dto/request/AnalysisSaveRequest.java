package pi.demo.domain.analysis.dto.request;

import lombok.Builder;

@Builder
public record AnalysisSaveRequest(String content, String imageUrl) {
}
