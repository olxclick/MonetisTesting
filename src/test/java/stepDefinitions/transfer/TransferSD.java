package stepDefinitions.transfer;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.DashboardPage;
import pages.TransferPage;
import stepDefinitions.login.LoginSD;
import utils.Utils;

public class TransferSD {
    private final WebDriver driver;
    private final Utils utils;
    private final DashboardPage dashboardPage;
    private final TransferPage transferPage;
    private int balanceBefore;

    public TransferSD(){
        driver = LoginSD.getDriver();
        dashboardPage = new DashboardPage(driver);
        transferPage = new TransferPage(driver);
        utils = new Utils(driver);
    }

    @When("I select transfer to own account")
    public void selectTransferToOwn() {
        dashboardPage.clickTransfer();
    }

    @And("I fill in the form and click on next")
    public void fillTransferForm(){
        transferPage.transactionDetails(null, 100);
        transferPage.sendDetails();
    }

    @And("I fill in the form with IBAN and click on next")
    public void fillTransferFormIBAN(){
        transferPage.transactionDetails("PT50102402094572332789752", 100);
        transferPage.sendDetails();
    }

    @Then("Verify success transfer page appears")
    public void validateTransfer(){
        By successLocator = By.xpath("//button[text()='Close']");

        utils.waitForElementToBeVisible(successLocator, 10);
        WebElement successMessage = driver.findElement(successLocator);
        Assert.assertTrue(successMessage.isDisplayed(), "Could not complete transfer!");
        transferPage.closeButton();
    }

    @When("I access accounts page")
    public void accessAccountsPage() {
        dashboardPage.clickAccounts();
    }

    @Given("I store the balance before the transfer")
    public void storeBalanceBeforeTransfer() {
        dashboardPage.clickAccounts();
        balanceBefore = transferPage.getGivenBalance(driver);
    }

    @Then("verify savings account balance increased")
    public void verifyAccountBalance(){
        int balanceAfter = transferPage.getGivenBalance(driver);
        Assert.assertEquals(balanceAfter, balanceBefore + 100, "Balance did not increase correctly!");
    }
}
