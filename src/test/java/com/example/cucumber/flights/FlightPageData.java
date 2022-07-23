package com.example.cucumber.flights;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource("googleflights/${language}.properties")
public class FlightPageData {

    @Value("${flight.application.url}")
    private String applicationUrl;

    @Value("${flight.application.labels}")
    private List<String> applicationLabels;

    public String getApplicationUrl() {
        return applicationUrl;
    }

    public List<String> getApplicationLabels() {
        return applicationLabels;
    }
}
