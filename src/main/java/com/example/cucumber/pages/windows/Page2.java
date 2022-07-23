package com.example.cucumber.pages.windows;

import com.example.cucumber.christofw.annotations.Page;
import com.example.cucumber.christofw.annotations.Window;
import com.example.cucumber.pages.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page B")
public class Page2 extends BaseClass {

    @FindBy(id="area")
    private WebElement textArea;

    @Override
    public boolean isAt() {
        return this.wait.until(d -> textArea.isDisplayed());
    }

    public void enterText(final String text) {
        this.textArea.sendKeys(text);
    }
}
