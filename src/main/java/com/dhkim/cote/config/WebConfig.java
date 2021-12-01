package com.dhkim.cote.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dhkim.cote.config.interceptor.CommonInterceptor;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class WebConfig implements WebMvcConfigurer{ 
	
	@Autowired
	private CommonInterceptor commInterceptor;
	
	// CommonInterceptor 태울 URL 정의
	private static final List<String> COMMON_URL_PATTERNS = Arrays.asList("/gateway/hikVision/*", "/board", "/user");
	
	// 인터셉터별 check url 기술
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(commInterceptor).addPathPatterns(COMMON_URL_PATTERNS);
	}
	
	// swagger
	private static final String API_NAME = "CodingTestAPI";
    private static final String API_VERSION = "0.0.1";
    private static final String API_DESCRIPTION = "설명";

    @Bean
    public Docket api() {
        Parameter parameterBuilder = new ParameterBuilder()
            .name(HttpHeaders.AUTHORIZATION)
            .description("Access Tocken")
            .modelRef(new ModelRef("string"))
            .parameterType("header")
            .required(false)
            .build();

        List<Parameter> globalParamters = new ArrayList<>();
        globalParamters.add(parameterBuilder);

        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(globalParamters)
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.dhkim.cote"))
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    public ApiInfo apiInfo() {
	return new ApiInfoBuilder()
		.title(API_NAME)
		.version(API_VERSION)
		.description(API_DESCRIPTION)
		.build();
    }
    
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("swagger-ui").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars").addResourceLocations("classpath:/META-INF/resources/webjars/");
		/*
	    registry.addResourceHandler("/resources/**").addResourceLocations("resources/");
	    registry.addResourceHandler("/resource/**").addResourceLocations("WEB-INF/resources/");
		if (!registry.hasMappingForPattern("/**")) {
		      registry.addResourceHandler("/**").addResourceLocations(
		          CLASSPATH_RESOURCE_LOCATIONS);
		}
        registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
        */
    }
	
}
