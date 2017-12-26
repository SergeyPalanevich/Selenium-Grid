package com.epam.grid.features.google.tests;

import com.epam.grid.core.driver.DriverTypes;
import com.epam.grid.features.google.pages.HomePage;
import com.epam.grid.features.google.pages.ResultPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.grid.core.driver.DriverManager.closeDriver;
import static com.epam.grid.core.driver.DriverManager.getDriver;

public class FirefoxTest {
    private static final String EPAM = "EPAM";
    private static final String URL = "https://google.com";
    private static WebDriver driver;

    @DataProvider(name = "Browser")
    public static Object[][] credentials() {
        return new Object[][]{
                {DriverTypes.FIREFOX}
        };
    }

    @Test(dataProvider = "Browser")
    public void runSearch(DriverTypes browser){
        driver = getDriver(browser);
        driver.get(URL);
        HomePage home = new HomePage(driver);
        ResultPage result = home.runSearch(EPAM);
        Assert.assertTrue(result.checkTitle());
    }

    @AfterMethod()
    public void cleanUp() {
        driver.close();
        driver = null;
        closeDriver();
    }
}
