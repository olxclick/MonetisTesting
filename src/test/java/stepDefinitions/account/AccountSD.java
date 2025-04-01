package stepDefinitions.account;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.AccountsPage;
import stepDefinitions.login.LoginSD;

import java.time.Duration;

public class AccountSD {
    private final WebDriver driver;
    private final AccountsPage accountsPage;

    public AccountSD(){
        this.driver = LoginSD.getDriver();
        this.accountsPage = new AccountsPage(driver);
    }

    @When("I click on new account button")
    public void createAccountTest(){
        accountsPage.clickNewAccount();
    }

    @And("I fill the details in the pop up and create account")
    public void insertAccountDetails(){
        accountsPage.newAccountDetails("testing", "100");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        wait.until(d -> submitButton.isEnabled());
    }

    @Then("I validate the account creation")
    public void verifyAccountCreation() {
        Assert.assertTrue(accountsPage.getAccount(driver, "testing", "100"), "Account creation failed");
    }
}
