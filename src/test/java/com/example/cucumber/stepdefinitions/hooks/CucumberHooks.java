package com.example.cucumber.stepdefinitions.hooks;

import com.example.cucumber.christofw.annotations.LazyAutowired;
import com.example.cucumber.christofw.services.ScreenshotService;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

public class CucumberHooks {

    @LazyAutowired
    private ScreenshotService screenshotService;

    @LazyAutowired
    private ApplicationContext applicationContext;

    @AfterStep
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(screenshotService.getScreenShot(), "image/png", scenario.getName());
        }
    }

    @After
    public void afterScenario() {
        applicationContext.getBean(WebDriver.class).quit();
    }
}
