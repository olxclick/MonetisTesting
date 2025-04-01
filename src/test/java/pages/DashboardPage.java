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
        clickSettings();
        utils.waitAndClick(By.xpath("//span[text()='Delete account']"));
        utils.waitForLoadingScreenToDisappear();
        utils.waitAndSendKeys(By.name("confirmDeletePassword"), "SecurePWD#12");
        utils.waitAndClick(By.xpath("//button[@type='submit']"));
    }

    public void clickTransfer(){
        utils.waitForLoadingScreenToDisappear();
        utils.waitAndClick(By.xpath("//span[text()='Transfer']"));
        utils.waitForLoadingScreenToDisappear();
    }

    public void clickPayments(){
        utils.waitForLoadingScreenToDisappear();
        utils.waitAndClick(By.xpath("//span[text()='Payments']"));
        utils.waitForLoadingScreenToDisappear();
    }

    public void clickTransactions(){
        utils.waitForLoadingScreenToDisappear();
        utils.waitAndClick(By.xpath("//span[text()='Transactions']"));
        utils.waitForLoadingScreenToDisappear();
    }

    public void clickAccounts(){
        utils.waitForLoadingScreenToDisappear();
        utils.waitAndClick(By.xpath("//span[text()='Accounts']"));
        utils.waitForLoadingScreenToDisappear();
    }

    public void clickDashboard(){
        utils.waitAndClick(By.xpath("//span[text()='Dashboard']"));
        utils.waitForLoadingScreenToDisappear();
    }

    public void clickSettings(){
        utils.waitForLoadingScreenToDisappear();
        utils.waitAndClick(By.xpath("//span[text()='Settings']"));
        utils.waitForLoadingScreenToDisappear();
    }

    public void clickLogout(){
        utils.waitAndClick(By.xpath("//span[text()='Log out']"));
        utils.waitForLoadingScreenToDisappear();
    }
}
