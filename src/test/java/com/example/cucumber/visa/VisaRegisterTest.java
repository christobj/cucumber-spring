package com.example.cucumber.visa;

import com.example.cucumber.SpringBaseTestNGTests;
import com.example.cucumber.christofw.annotations.LazyAutowired;
import com.example.cucumber.entity.Visa;
import com.example.cucumber.pages.visa.VisaRegistrationPage;
import com.example.cucumber.repository.VisaRepository;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;

public class VisaRegisterTest extends SpringBaseTestNGTests {

    @LazyAutowired
    private VisaRegistrationPage registrationPage;

    @LazyAutowired
    private VisaRepository visaRepository;

    @Test(dataProvider = "getData")
    public void register(Visa u) {
        this.registrationPage.goTo();
        this.registrationPage.setNames(u.getFirstName(), u.getLastName());
        this.registrationPage.setCountryFromAndTo(u.getFromCountry(), u.getToCountry());
        this.registrationPage.setBirthDate(u.getDob().toLocalDate());
        this.registrationPage.setContactDetails(u.getCustomerEmail(), u.getPhone());
        this.registrationPage.setComments(u.getComments());
        this.registrationPage.submit();
        System.out.println(this.registrationPage.getConfirmationNumber());
    }

    @DataProvider
    public Object[] getData(){
        return this.visaRepository.findByDobBetween(
                Date.valueOf("1995-01-01"),
                Date.valueOf("1997-01-01"))
                .stream()
                .limit(3)
                .toArray();
    }
}
