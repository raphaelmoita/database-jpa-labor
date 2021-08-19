package org.moita.mtmc.configuration;

import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;

public class Swagger {
    public static final String GAME_TAG = "GAME";
    public static final String STORE_TAG = "STORE";
    public static final String BASE_PACKAGE = "org.moita.mtmc.rest";

    public static Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                            .title("Many to many relation")
                            .description("Testing many-to-many JPA")
                            .contact(new Contact("Many-To-Many", "", "rapha@"))
                            .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .build()
                .tags(new Tag(GAME_TAG, "Game REST API"))
                .tags(new Tag(STORE_TAG, "Store REST API"))
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false);
    }

    public static ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Many to many relation")
                .description("Testing many-to-many JPA")
                .build();
    }
}
