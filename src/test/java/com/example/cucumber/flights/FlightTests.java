package com.example.cucumber.flights;

import com.example.cucumber.SpringBaseTestNGTests;
import com.example.cucumber.christofw.annotations.LazyAutowired;
import com.example.cucumber.pages.flights.FlightPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightTests extends SpringBaseTestNGTests {

    @LazyAutowired
    FlightPage flightPage;

    @Autowired
    FlightPageData flightPageData;

    @Test
    public void flight() {
        this.flightPage.goTo(this.flightPageData.getApplicationUrl());
        Assert.assertTrue(this.flightPage.isAt());
        Assert.assertEquals(this.flightPage.getPresentationLabels(), this.flightPageData.getApplicationLabels());
        this.flightPage.close();
    }
}
