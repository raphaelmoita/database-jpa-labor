package org.moita.mtmc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@ComponentScan
public class ManyToManyCompositeKeyConfiguration {

    @Bean
    public Docket docket() {
        return Swagger.docket();
    }
}
