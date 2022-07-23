package com.example.cucumber.stepdefinitions.google;

import com.example.cucumber.christofw.annotations.LazyAutowired;
import com.example.cucumber.pages.google.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

@SpringBootTest
@CucumberContextConfiguration
public class GoogleStepDefs {

    @LazyAutowired
    private SearchPage searchPage;

    @Given("To be at Google Home Page")
    public void loadGoogle() {
        searchPage.goTo();
    }

    @When("Search for {word} at Search Area")
    public void search(String keyword) {
        searchPage.getSearchComponent().search(keyword);
    }

    @Then("Search Results should be loaded")
    public void verifyResultsLoaded() {
        searchPage.getSearchResultComponent().isAt();
    }

    @And("Minimum {int} records should be loaded")
    public void verifyResultsLoadedCount(int count) {
        Assert.assertTrue(searchPage.getSearchResultComponent().getCount() >= count);
    }
}
