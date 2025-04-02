package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Utils;

public class TransferPage {
    private final Utils utils;

    public TransferPage(WebDriver driver) {
        this.utils = new Utils(driver);
    }

    public String getBalance() {
        WebElement balanceElement = utils.getWait(10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".item.balance")));
        return balanceElement.getText();
    }

    public int getGivenBalance(WebDriver driver) {
        WebElement acc = driver.findElement(By.xpath("//div[@class='account']/h2[text()='Savings']/following-sibling::p"));

        String balanceText = acc.getText().trim();

        balanceText = balanceText.replaceAll(",.*", "");
        balanceText = balanceText.replaceAll("[^0-9]", "");

        return Integer.parseInt(balanceText);
    }

    public void transactionDetails(String iban, float amount){
        if (getBalance().equalsIgnoreCase(String.valueOf(amount)))
            return;

        if (iban == null){
            utils.waitAndClick(By.xpath("//span[text()='Own Account']"));
            utils.selectDropdownOption("react-select-3-input", "Savings");
        }
        else {
            utils.waitAndClick(By.xpath("//span[text()='Other Account']"));
            utils.waitAndSendKeys(By.name("iban"), iban);
        }
        utils.waitAndSendKeys(By.name("amount"), String.valueOf(amount));
    }

    public void sendDetails(){
        utils.waitAndClick(By.xpath("//button[text()='Next']"));
        utils.waitAndClick(By.xpath("//button[text()='Next']"));
    }

    public void closeButton(){
        utils.waitAndClick(By.xpath("//button[text()='Close']"));
    }
}
