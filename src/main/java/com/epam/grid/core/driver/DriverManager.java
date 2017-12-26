package com.epam.grid.core.driver;

import org.openqa.selenium.WebDriver;

import static com.epam.grid.core.driver.CreatorRemoteDriver.create;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver(DriverTypes name) {
        if (driver == null) {
            driver = create(name);
        }
        return driver;
    }

    public static void closeDriver() {
       driver = null;
    }
}
