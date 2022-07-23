package com.example.cucumber.pages.google;

import com.example.cucumber.christofw.annotations.PageComponent;
import com.example.cucumber.pages.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageComponent
public class SearchComponent extends BaseClass {

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private List<WebElement> searchButtons;


    @Override
    public boolean isAt() {
        return this.wait.until(d -> this.searchBox.isDisplayed());
    }

    public void search(final String keyword) {
        this.searchBox.sendKeys(keyword, Keys.TAB);
        this.searchButtons
                .stream()
                .filter(e -> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }
}
