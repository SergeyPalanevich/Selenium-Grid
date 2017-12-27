package com.epam.grid.features.google.tests;

import com.epam.grid.core.driver.DriverManager;
import com.epam.grid.core.driver.DriverTypes;
import com.epam.grid.features.google.pages.HomePage;
import com.epam.grid.features.google.pages.ResultPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ChromeTest {
    private static final String EPAM = "EPAM";
    private static final String URL = "https://google.com";
    private WebDriver driver;
    private DriverManager manager = new DriverManager();

    @DataProvider(name = "Browser")
    public static Object[][] credentials() {
        return new Object[][]{
                {DriverTypes.CHROME}
        };
    }

    @Test(dataProvider = "Browser")
    public void runSearch(DriverTypes browser){
        driver = manager.getDriver(browser);
        driver.get(URL);
        HomePage home = new HomePage(driver);
        ResultPage result = home.runSearch(EPAM);
        Assert.assertTrue(result.checkTitle());
    }

    @AfterMethod()
    public void cleanUp() {
        manager.closeDriver();
    }
}
