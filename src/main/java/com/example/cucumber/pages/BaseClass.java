package com.example.cucumber.pages;

import com.example.cucumber.christofw.annotations.LazyAutowired;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.PostConstruct;

public abstract class BaseClass {

    @LazyAutowired
    protected WebDriver driver;

    @LazyAutowired
    protected WebDriverWait wait;

    public abstract boolean isAt();

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
    }
}
