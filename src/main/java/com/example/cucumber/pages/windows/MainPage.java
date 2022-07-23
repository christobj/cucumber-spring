package com.example.cucumber.pages.windows;

import com.example.cucumber.christofw.annotations.Page;
import com.example.cucumber.pages.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class MainPage extends BaseClass {

    @FindBy(id="pageA")
    private WebElement pageA;

    @FindBy(id="pageB")
    private WebElement pageB;

    @FindBy(id="pageC")
    private WebElement pageC;

    @FindBy(id="area")
    private WebElement textArea;

    @Override
    public boolean isAt() {
        return this.wait.until(d -> textArea.isDisplayed());
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/window/main.html");
    }

    public void close() {
        this.driver.quit();
    }

    public void openAllLinks() {
        this.pageA.click();
        this.pageB.click();
        this.pageC.click();
    }

}
