package pi.demo.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
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
                        .title("PawGenics")
                        .description("Pet health management web/app using genetic testing and AI-based behavior analysis to keep your pet healthy!")
                        .version("Api version")
                        .contact(new Contact()
                                .name("PI")
                                .url("http://www.pi-company.com")
                                .email("contact@pi-company.com")));
    }
}
