package team.awesome.pet.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This acts as a UI for the project where all the API calls will be visible to be used
 *
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfigApplication {

  @Bean
  public Docket postsApi() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo())
        .select().paths(postPaths()).build();
  }

  @SuppressWarnings("unchecked")
  private Predicate<String> postPaths() {
    // return Predicates.or(PathSelectors.regex("/pets.*"));
    return Predicates.or(PathSelectors.regex("/pets.*"), PathSelectors.regex("/pet-types.*"),
        PathSelectors.regex("/shelters.*"), PathSelectors.regex("/users.*"),
        PathSelectors.regex("/tracks.*"));
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Springfox Pet Rescue Organization API")
        .description("Helped to relocate lost pet and return to its owner")
        .termsOfServiceUrl("http://springfox.io").contact("springfox")
        .license("Apache License Version 2.0")
        .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE").version("2.0")
        .build();
  }

}
