package com.abeldevelop.blog.category.integration.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"${abeldevelop.configuration.component-scan}"})
@EntityScan("${abeldevelop.configuration.entity-scan}")
@EnableJpaRepositories("${abeldevelop.configuration.enable-jpa-repositories}")
@SpringBootApplication
public class CucumberSpringBootConfiguration {

}
