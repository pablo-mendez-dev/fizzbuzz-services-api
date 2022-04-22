package com.intraway.fizzbuzz;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class FizzbuzzServicesApiManagerConfiguration {

	@Bean
	  public GroupedOpenApi publicFizzbuzzServicesApi() {
	      return GroupedOpenApi.builder()
	              .group("intraway-fizzbuzz")
	              .pathsToMatch("/api/")
	              .build();
	  }

}
