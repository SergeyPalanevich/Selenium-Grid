package com.epam.grid.core.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private WebDriver driver;

    public WebDriver getDriver(DriverTypes name) {
        if (driver == null) {
            driver = new CreatorRemoteDriver().create(name);
        }
        return driver;
    }

    public void closeDriver() {
//        driver.quit();
        driver.close();
        driver = null;
    }
}
