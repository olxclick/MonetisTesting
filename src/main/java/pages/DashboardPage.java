package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class DashboardPage {
    private final Utils utils;

    public DashboardPage(WebDriver driver) {
        this.utils = new Utils(driver);
    }

    public void removeTestData() {
        utils.waitForLoadingScreenToDisappear();
        utils.waitAndClick(By.xpath("//span[text()='Settings']"));
        utils.waitForLoadingScreenToDisappear();
        utils.waitAndClick(By.xpath("//span[text()='Delete account']"));
        utils.waitForLoadingScreenToDisappear();
        utils.waitAndSendKeys(By.name("confirmDeletePassword"), "SecurePWD#12");
        utils.waitAndClick(By.xpath("//button[@type='submit']"));
    }
}
