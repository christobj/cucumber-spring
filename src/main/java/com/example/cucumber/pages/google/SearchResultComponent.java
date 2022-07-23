package com.example.cucumber.pages.google;

import com.example.cucumber.christofw.annotations.PageComponent;
import com.example.cucumber.pages.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageComponent
public class SearchResultComponent extends BaseClass {

    @FindBy(xpath = "//div[@id='search']//a")
    private List<WebElement> searchResults;

    @Override
    public boolean isAt() {
        return this.wait.until(d -> !this.searchResults.isEmpty());
    }

    public int getCount() {
        return this.searchResults.size();
    }
}
