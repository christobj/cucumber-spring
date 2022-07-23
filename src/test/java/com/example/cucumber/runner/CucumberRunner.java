package com.example.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "classpath:features",
        tags = "not @smoke",
        glue = "com.example.cucumber.stepdefinitions",
        plugin = {
                "pretty",
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

        @DataProvider(parallel = true)
        @Override
        public Object[][] scenarios() {
                return super.scenarios();
        }
}
