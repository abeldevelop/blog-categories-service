package com.abeldevelop.blog.category.integration.config;

import static com.abeldevelop.blog.category.integration.config.CucumberTestContext.CONTEXT;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.abeldevelop.architecture.library.test.integration.cucumber.common.CucumberTestConstants;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = CucumberSpringBootConfiguration.class)
public class CucumberSpringContextConfiguration {

    @LocalServerPort
    int randomServerPort;
    
    @Before
    public void setUp(Scenario scenario) {
        CONTEXT.setTestCase(scenario.getName().substring(scenario.getName().lastIndexOf(" ")).trim());
        log.debug(CucumberTestConstants.INTEGRATION_TEST + "");
        log.debug(CucumberTestConstants.INTEGRATION_TEST + "");
        log.debug(CucumberTestConstants.INTEGRATION_TEST + "");
        log.debug(CucumberTestConstants.INTEGRATION_TEST + "");
        log.debug(CucumberTestConstants.INTEGRATION_TEST + "-------------- Start Scenario: {}, Line:{}, File: {}--------------", scenario.getName(), scenario.getLine(), scenario.getUri());
        log.debug(CucumberTestConstants.INTEGRATION_TEST + "");
        log.debug(CucumberTestConstants.INTEGRATION_TEST + "");
        log.debug(CucumberTestConstants.INTEGRATION_TEST + "");
        log.debug(CucumberTestConstants.INTEGRATION_TEST + "");
    }
}
