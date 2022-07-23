package com.example.cucumber.christofw.aop;

import com.example.cucumber.christofw.annotations.LazyAutowired;
import com.example.cucumber.christofw.annotations.Window;
import com.example.cucumber.christofw.services.WindowSwitchService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowsAspect {

    @LazyAutowired
    private WindowSwitchService windowSwitchService;

    @Before("@target(window) && within(com.example.cucumber..*)")
    public void before(Window window) {
        this.windowSwitchService.switchToWindowByName(window.value());
    }

    @After("@target(window) && within(com.example.cucumber..*)")
    public void after(Window window) {
        this.windowSwitchService.switchToWindowByIndex(0);
    }

}
