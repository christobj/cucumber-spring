package com.example.cucumber.windows;

import com.example.cucumber.SpringBaseTestNGTests;
import com.example.cucumber.christofw.annotations.LazyAutowired;
import com.example.cucumber.pages.windows.MainPage;
import com.example.cucumber.pages.windows.Page1;
import com.example.cucumber.pages.windows.Page2;
import com.example.cucumber.pages.windows.Page3;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PageTest extends SpringBaseTestNGTests {

    @LazyAutowired
    private MainPage mainPage;

    @LazyAutowired
    private Page1 page1;

    @LazyAutowired
    private Page2 page2;

    @LazyAutowired
    private Page3 page3;

    @BeforeClass
    private void before() {
        this.mainPage.goTo();
        this.mainPage.isAt();
        this.mainPage.openAllLinks();
    }

    @Test(dataProvider = "getIndex")
    private void page(int index) {
        this.page1.enterText(index + "\n");
        this.page2.enterText((2*index) + "\n");
        this.page3.enterText((3*index) + "\n");
    }

    @DataProvider
    private Object[] getIndex() {
        return new Object[]{
                3,
                4,
                5,
                6,
                7
        };
    }
}
