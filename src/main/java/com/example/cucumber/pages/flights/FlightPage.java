package com.example.cucumber.pages.flights;

import com.example.cucumber.christofw.annotations.Page;
import com.example.cucumber.christofw.annotations.TakeScreenshot;
import com.example.cucumber.pages.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Page
public class FlightPage extends BaseClass {

    @FindBy(xpath = "//button[@role='presentation']/div[2]")
    private List<WebElement> presentationIcons;

    @Override
    public boolean isAt() {
        return this.wait.until(e -> !this.presentationIcons.isEmpty());
    }

    public void goTo(String targetUrl) {
        this.driver.get(targetUrl);
    }

    @TakeScreenshot
    public List<String> getPresentationLabels() {
        return this.presentationIcons
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public void close() {
        this.driver.quit();
    }
}
