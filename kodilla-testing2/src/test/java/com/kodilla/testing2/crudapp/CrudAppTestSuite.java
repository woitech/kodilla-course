package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://woitech.github.io";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTest() {
        initDriver();
        generator = new Random();
    }

    @After
    public void cleanUpAfterTest() {
        cleanupDriver();
    }

    private void initDriver() {
        cleanupDriver();
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
    }

    private void cleanupDriver() {
        if (driver != null) {
            driver.close();
        }
    }

    private String createCrudApptestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[@method=\"POST\" and contains(@action, \"/tasks\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[@method=\"POST\" and contains(@action, \"/tasks\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[@method=\"POST\" and  contains(@action, \"/tasks\")]/fieldset[3]/button";

        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);
        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);
        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();

        Thread.sleep(2000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                    anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard
                            = theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });

        Thread.sleep(5000);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        final String TRELLO_USER = "wojlow@gmail.com";
        final String TRELLO_PASS = "MkOl9)6Hyu";

        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys(TRELLO_USER);
        driverTrello.findElement(By.id("password")).sendKeys(TRELLO_PASS);
        driverTrello.findElement(By.id("login")).submit();

        Thread.sleep(2000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//span[@title=\"Kodilla Application\"]")).size() > 0)
                .forEach(aHref -> aHref.click());

        Thread.sleep(2000);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .filter(theSpan -> theSpan.getText().contains(taskName))
                .collect(toList())
                .size() > 0;

        driverTrello.close();

        return result;
    }

    private void deleteCrudAppTestTask(String taskName) {
        initDriver();
        WebDriverWait wait = new WebDriverWait(driver, 2, 100);

        By locator = By.xpath("//form[@class=\"datatable__row\"]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        List<WebElement> taskRows = driver.findElements(locator).stream()
                .filter(anyForm -> anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName)).collect(toList());

        assertNotEquals(0, taskRows.size());

        for(WebElement element : taskRows) {
            wait.until(ExpectedConditions.visibilityOf(element));
        }

        for (WebElement taskRow : taskRows) {
            WebElement button = taskRow.findElement(By.xpath(".//button[@data-task-delete-button=\"\"]"));
            wait.until(ExpectedConditions.elementToBeClickable(button)).click();
            wait.until(ExpectedConditions.stalenessOf(taskRow));
        }
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudApptestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
        deleteCrudAppTestTask(taskName);
    }
}
