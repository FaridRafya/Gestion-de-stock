package ma.rafya.gestiondestock.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static ma.rafya.gestiondestock.Utils.Constant.APP_ROOT;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("GESTION DE STOCK API DOCUMENTATION")
                                .title("gestion de stock REST API")
                                .build()
                )
                .groupName("rest API V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("ma.rafya.gestiondestock"))
                .paths(PathSelectors.ant(APP_ROOT+"/**")).build();

    }
}
