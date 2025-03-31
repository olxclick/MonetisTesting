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
    private final WebDriverWait wait;

    public Utils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitAndClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void waitAndSendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }

    public void selectDropdownOption(String dropdownInputId, String value) {
        waitAndClick(By.className("css-13cymwt-control"));

        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(dropdownInputId)));
        inputField.sendKeys(value);
        inputField.sendKeys(Keys.ENTER);
    }

    public void waitUrl(String url){
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public void removeTestData() {
        waitForLoadingScreenToDisappear();
        waitAndClick(By.xpath("//span[text()='Settings']"));
        waitForLoadingScreenToDisappear();
        waitAndClick(By.xpath("//span[text()='Delete account']"));
        waitForLoadingScreenToDisappear();
        waitAndSendKeys(By.name("confirmDeletePassword"), "SecurePWD#12");
        waitAndClick(By.xpath("//button[@type='submit']"));
    }

    public void waitForLoadingScreenToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading_screen")));
    }

}
