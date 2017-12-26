package com.epam.grid.core.driver;

import com.epam.grid.core.exeption.NoSuchWebDriverExeption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

class CreatorRemoteDriver {

    private static final String HUB = "http://localhost:4444/wd/hub";
    private static final long TIME_OUT = 20;

    public static WebDriver create(DriverTypes name) throws NoSuchWebDriverExeption {
        WebDriver driver = null;

        switch (name) {
            case CHROME:
                try {
                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                    driver = new RemoteWebDriver(new URL(HUB), capabilities);
                    driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
                    driver.manage().timeouts().pageLoadTimeout(TIME_OUT, TimeUnit.SECONDS);
                    driver.manage().timeouts().setScriptTimeout(TIME_OUT, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    return driver;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            case FIREFOX:
                try {
                    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                    driver = new RemoteWebDriver(new URL(HUB), capabilities);
                    driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
                    driver.manage().timeouts().pageLoadTimeout(TIME_OUT, TimeUnit.SECONDS);
                    driver.manage().timeouts().setScriptTimeout(TIME_OUT, TimeUnit.SECONDS);
                    driver.manage().window().maximize();
                    return driver;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
        }

        return driver;
    }

}
