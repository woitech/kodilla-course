package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {
    public static final String SEARCHFIELD = "gh-ac";
    public static final String EBAY_HOME = "https://www.ebay.com";

    public static void main(String[] args) {
        EBayTestingApp testApp = new EBayTestingApp();
        testApp.testWith(WebDriverConfig.CHROME);
        testApp.testWith(WebDriverConfig.FIREFOX);
    }

    private void testWith(String browser) {
        WebDriver driver = WebDriverConfig.getDriver(browser);
        driver.get(EBAY_HOME);
        WebElement searchField = driver.findElement(By.id(SEARCHFIELD));
        searchField.sendKeys("Laptop");
        searchField.submit();
    }
}
