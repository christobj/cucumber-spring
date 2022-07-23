package com.example.cucumber.christofw.services;

import com.example.cucumber.christofw.annotations.LazyAutowired;
import com.example.cucumber.christofw.annotations.Service;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

@Service
public class WindowSwitchService {

    @LazyAutowired
    private ApplicationContext context;

    public void switchToWindowByName(final String windowName) {
        WebDriver driver = context.getBean(WebDriver.class);
        driver.getWindowHandles()
                .stream()
                .map(handle -> driver.switchTo().window(handle).getTitle())
                .filter(t -> t.startsWith(windowName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Specified Window Not Found"));
    }

    public void switchToWindowByIndex(final int index) {
        WebDriver driver = context.getBean(WebDriver.class);
        String[] handles = driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(handles[index]);
    }
}
