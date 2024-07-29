package pi.demo.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("demo")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("demo")
                        .description("PIPIPIPIPIPIPIPIPIPIPPI")
                        .version("Api version"));
    }
}
