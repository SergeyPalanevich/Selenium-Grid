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

    @FindBy(xpath = "//a[@class='gb_Ba gb_wd gb_fd' and contains(text(), 'NOT INTERESTED')]")
    public WebElement ie;

    public ResultPage runSearch(String criteria) {
        searchInput.clear();
        searchInput.sendKeys(criteria);
        searchInput.sendKeys(Keys.ENTER);
        return new ResultPage(driver);
    }
}
