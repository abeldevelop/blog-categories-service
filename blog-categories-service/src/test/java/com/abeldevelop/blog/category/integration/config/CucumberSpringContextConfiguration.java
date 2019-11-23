package com.abeldevelop.blog.category.integration.config;

import static com.abeldevelop.blog.category.integration.config.TestContext.CONTEXT;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.abeldevelop.blog.category.service.BlogCategoriesServiceApplication;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = BlogCategoriesServiceApplication.class)
public class CucumberSpringContextConfiguration {

    @LocalServerPort
    int randomServerPort;
    
    @Before
    public void setUp(Scenario scenario) {
        CONTEXT.setTestCase(scenario.getName().substring(scenario.getName().lastIndexOf(" ")).trim());
    }
}
