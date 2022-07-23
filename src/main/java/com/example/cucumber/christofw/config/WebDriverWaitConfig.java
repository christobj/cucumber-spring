package com.example.cucumber.christofw.config;

import com.example.cucumber.christofw.annotations.LazyConfiguration;
import com.example.cucumber.christofw.annotations.PrototypeScopeBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;

import java.time.Duration;

@LazyConfiguration
public class WebDriverWaitConfig {

    @Value("${default.timeout:30}")
    private int timeout;

    @PrototypeScopeBean
    public WebDriverWait webDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(this.timeout));
    }
}
