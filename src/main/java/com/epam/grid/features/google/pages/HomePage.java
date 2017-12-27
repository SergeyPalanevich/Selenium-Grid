package com.epam.grid.features.google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "lst-ib")
    public WebElement searchInput;

    public ResultPage runSearch(String criteria) {
        searchInput.clear();
        searchInput.sendKeys(criteria);
        searchInput.sendKeys(Keys.ENTER);
        return new ResultPage(driver);
    }
}
