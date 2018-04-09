package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String FACEBOOK_HOME = "https://www.facebook.com/";

    public static final String REGISTER_ACTION = "https://m.facebook.com/reg/";
    public static final String REGISTER_PARAM_BIRTH_DAY = "birthday_day";
    public static final String REGISTER_PARAM_BIRTH_MONTH = "birthday_month";
    public static final String REGISTER_PARAM_BIRTH_YEAR = "birthday_year";

    public static final String XPATH_FORM_REGISTER_DATA = "//form[@action=" + "\"" + REGISTER_ACTION + "\"" +"]";
    public static final String XPATH_SELECT_BIRTH_DAY
            = XPATH_FORM_REGISTER_DATA + "//select[@name=" + "\"" + REGISTER_PARAM_BIRTH_DAY + "\"" + "]";
    public static final String XPATH_SELECT_BIRTH_MONTH
            = XPATH_FORM_REGISTER_DATA + "//select[@name=" + "\"" + REGISTER_PARAM_BIRTH_MONTH + "\"" + "]";
    public static final String XPATH_SELECT_BIRTH_YEAR
            = XPATH_FORM_REGISTER_DATA + "//select[@name=" + "\"" + REGISTER_PARAM_BIRTH_YEAR + "\"" + "]";


    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(FACEBOOK_HOME);

        String eleventh= "11", may = "5", year = "2004";
        Select selectBirthDay = new Select(driver.findElement(By.xpath(XPATH_SELECT_BIRTH_DAY)));
        selectBirthDay.selectByValue(eleventh);
        Select selectBirthMonth = new Select(driver.findElement(By.xpath(XPATH_SELECT_BIRTH_MONTH)));
        selectBirthMonth.selectByValue(may);
        Select selectBirthYear = new Select(driver.findElement(By.xpath(XPATH_SELECT_BIRTH_YEAR)));
        selectBirthYear.selectByValue(year);
    }
}
