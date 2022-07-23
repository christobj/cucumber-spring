package com.example.cucumber.christofw.services;

import com.example.cucumber.christofw.annotations.LazyAutowired;
import com.example.cucumber.christofw.annotations.Service;
import com.github.javafaker.Faker;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Service
public class ScreenshotService {

    @LazyAutowired
    private ApplicationContext context;

    @LazyAutowired
    private Faker faker;

    @Value("${screenshot.path}")
    private Path screenshotPath;

    public void takeScreenshot() {
        File file = this.context.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        try {
            FileCopyUtils.copy(file, this.screenshotPath.resolve(faker.name().firstName() + ".png").toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] getScreenShot() {
        return this.context.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }
}
