package com.epam.grid.features.google.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForJSLoadComplete();
    }

    protected boolean waitForJSLoadComplete() {
        WebDriverWait wait = new WebDriverWait(driver, getDriverTimeout());

        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                return ((Long) (getJSExecutor(driver)).executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                return true;
            }
        };

        ExpectedCondition<Boolean> jsLoad = driver -> (getJSExecutor(driver)).executeScript("return document.readyState").toString().equals("complete");

        boolean jQuery = wait.until(jQueryLoad);
        boolean js = wait.until(jsLoad);
        return jQuery && js;
    }

    protected long getDriverTimeout() {
        return 25;
    }

    protected JavascriptExecutor getJSExecutor(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }
}
