package pi.demo.domain.sns.dto.request;

import lombok.Builder;

@Builder
public record SnsSaveRequest(String content, String imageUrl) {
}
