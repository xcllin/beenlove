package com.xcl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author xiangchunlin
 * @description swager集成
 * @date 2018年12月25日
 * @version 1.0.0
 */
@Configuration
@EnableSwagger2
public class Swagger2BootApp {

	@Value("${spring.swagger.show}")
	private boolean swaggerShow;

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).enable(swaggerShow).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.xcl.controller")).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("boot swagger api").description("Boot Api List").version("1.0").build();
	}

}
