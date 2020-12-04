package com.sal.config;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;


/**
 * swagger 配置
 */
@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class config {

    /**
     * 是否开启swagger
     */
    @Value("${swagger.enabled:true}")
    private boolean enabled;

    /**
     * 设置请求的统一前缀
     */
    @Value("${swagger.pathMapping:/}")
    private String pathMapping;

    @Bean
    public Docket groupRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //是否启用swagger
                .enable(enabled)
                //用来创建API的基本信息，展示在文档的页面中
                .apiInfo(groupApiInfo())
                //设置哪些接口暴露给Swagger展示
                .select()
                //扫描所有注解的api，这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //扫描指定包中的swagger注解
                .paths(PathSelectors.any()).build()
                //设置安全模式，swagger可以设置访问token
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.newArrayList(apiKey(), apiKey1())).pathMapping(pathMapping);
    }

    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }

    private ApiKey apiKey1() {
        return new ApiKey("Authorization", "Authorization", "header");
    }

    /**
     * 添加摘要信息
     *
     * @return
     */
    private ApiInfo groupApiInfo() {
        return new ApiInfoBuilder().title("retail-microservice")
                .termsOfServiceUrl("<div style='font-size:14px;color:red;'>RETAIL MICROSERVICES RESTful APIS</div>")
                .termsOfServiceUrl("http://www.retail.com")
                .version("1.8").build();
    }

    /**
     * 安全上下文
     *
     * @return
     */
    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

    /**
     * 安全模式，指定token通过AuthorizationScope头请求头传递
     */
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("Authorization", authorizationScopes));
    }

    private SecurityContext securityContext1() {
        return SecurityContext.builder().securityReferences(defaultAuth1())
                .forPaths(PathSelectors.regex("/.*")).build();
    }

    List<SecurityReference> defaultAuth1() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("serviceName", authorizationScopes));
    }
}
