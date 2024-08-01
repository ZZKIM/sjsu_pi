package pi.demo.domain.sns.dto.response;

import lombok.Builder;

@Builder
public record SnsAllReadResponse(String content, String imageUrl){
}
