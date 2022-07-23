package com.example.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@CucumberContextConfiguration
@SpringBootTest
public class SpringBaseTestNGTests extends AbstractTestNGSpringContextTests {
}
