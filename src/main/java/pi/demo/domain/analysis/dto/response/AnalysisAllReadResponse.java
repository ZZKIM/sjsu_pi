package pi.demo.domain.analysis.dto.response;

import lombok.Builder;

@Builder
public record AnalysisAllReadResponse(String content, String imageUrl){
}
