package com.example.cucumber.pages.google;

import com.example.cucumber.christofw.annotations.LazyAutowired;
import com.example.cucumber.christofw.annotations.Page;
import com.example.cucumber.pages.BaseClass;
import org.springframework.beans.factory.annotation.Value;

@Page
public class SearchPage extends BaseClass {

    @Value("${application.url}")
    private String url;

    @LazyAutowired
    private SearchComponent searchComponent;

    @LazyAutowired
    private SearchResultComponent searchResultComponent;

    public SearchComponent getSearchComponent() {
        return this.searchComponent;
    }

    public SearchResultComponent getSearchResultComponent() {
        return this.searchResultComponent;
    }

    public void goTo() {
        this.driver.get(url);
    }

    public void close() {
        this.driver.quit();
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }
}
