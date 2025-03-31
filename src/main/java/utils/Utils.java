package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Utils {
    private final WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    // Method to get a WebDriverWait instance with a custom timeout
    public WebDriverWait getWait(int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    public void waitAndClick(By locator) {
        getWait(10).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void waitAndSendKeys(By locator, String text) {
        WebElement element = getWait(10).until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public void selectDropdownOption(String dropdownInputId, String value) {
        waitAndClick(By.className("css-13cymwt-control"));
        WebElement inputField = getWait(10).until(ExpectedConditions.visibilityOfElementLocated(By.id(dropdownInputId)));
        inputField.sendKeys(value);
        inputField.sendKeys(Keys.ENTER);
    }

    public void waitUrl(String url, int timeout) {
        getWait(timeout).until(ExpectedConditions.urlToBe(url));
    }

    public void waitForLoadingScreenToDisappear() {
        getWait(15).until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading_screen")));
    }
}
