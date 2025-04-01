package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;
import java.util.List;

public class AccountsPage {
    private final Utils utils;

    public AccountsPage(WebDriver driver) {
        this.utils = new Utils(driver);
    }

    public boolean getAccount(WebDriver driver, String accountName, String expectedBalance){
        List<WebElement> accounts = driver.findElements(By.cssSelector(".account"));

        for (WebElement account : accounts) {
            String webName = account.findElement(By.tagName("h2")).getText().trim();
            String balanceText = account.findElement(By.tagName("p")).getText().trim();

            balanceText = balanceText.replaceAll(",.*", "");
            if (webName.equalsIgnoreCase(accountName) && expectedBalance.equalsIgnoreCase(balanceText)) {
                return true;
            }
        }
        return false;
    }

    public void clickNewAccount() {
        utils.waitForLoadingScreenToDisappear();
        utils.waitAndClick(By.className("new_account"));
    }

    public void newAccountDetails(String name, String deposit){
        utils.waitForLoadingScreenToDisappear();
        utils.waitAndSendKeys(By.xpath("//input[@placeholder='My next vacations']"), name);
        utils.waitAndSendKeys(By.name("amount"), deposit);
        utils.waitAndClick(By.xpath("//button[@type='submit']"));
    }
}
