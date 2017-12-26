package com.epam.grid.features.google.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ResultPage extends BasePage{
    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@href, 'epam.com')]")
    public WebElement link;

    public boolean checkTitle() {
        return link.isEnabled();
    }
}
