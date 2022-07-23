package com.example.cucumber.google;

import com.example.cucumber.SpringBaseTestNGTests;
import com.example.cucumber.christofw.annotations.LazyAutowired;
import com.example.cucumber.pages.google.SearchPage;
import com.example.cucumber.christofw.services.ScreenshotService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Search2Test extends SpringBaseTestNGTests {

    @LazyAutowired
    SearchPage searchPage;

    @LazyAutowired
    ScreenshotService screenshotService;

    @Test
    public void search() {
        this.searchPage.goTo();
        Assert.assertTrue(this.searchPage.isAt());
        this.searchPage.getSearchComponent().search("Selenium");
        Assert.assertTrue(this.searchPage.getSearchResultComponent().isAt());
        Assert.assertTrue(this.searchPage.getSearchResultComponent().getCount() > 2);
        screenshotService.takeScreenshot();
        this.searchPage.close();
    }
}
