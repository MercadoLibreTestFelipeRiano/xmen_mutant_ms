package com.xmen.xmen_mutant_ms.infraestructure.http.docs.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(
                        RequestHandlerSelectors.basePackage("com.xmen.xmen_mutant_ms")
                )
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "API REST XMEN",
                "X-MEN REST API for Mercado Libre Technical Test.",
                "1.0",
                "http://codmind.com/terms",
                new Contact("Felipe Esteban Riaño Pineda", "https://www.linkedin.com/in/felipe-r-pineda/", "felipepineda1997@gmail.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }

//    @Bean
//    public ApiInfo metaInfo() {
//
//        ApiInfo apiInfo = new ApiInfo(
//                "API REST XMEN",
//                "X-MEN REST API for Mercado Libre Technical Test.",
//                "1.0",
//                "Terms of Service",
//                new Contact("Felipe Esteban Riaño Pineda", "https://www.linkedin.com/in/felipe-r-pineda/",
//                        "felipepineda1997@gmail.com"),
//                "Apache License Version 2.0",
//                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
//        );
//
//        return apiInfo;
//    }

}
