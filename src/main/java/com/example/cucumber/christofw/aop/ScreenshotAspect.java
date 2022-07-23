package com.example.cucumber.christofw.aop;

import com.example.cucumber.christofw.annotations.LazyAutowired;
import com.example.cucumber.christofw.annotations.TakeScreenshot;
import com.example.cucumber.christofw.services.ScreenshotService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ScreenshotAspect {

    @LazyAutowired
    private ScreenshotService screenshotService;

    @After("@annotation(takeScreenshot)")
    public void before(TakeScreenshot takeScreenshot) {
        this.screenshotService.takeScreenshot();
    }

}
