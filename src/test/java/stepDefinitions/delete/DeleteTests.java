package stepDefinitions.delete;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DashboardPage;
import pages.LoginPage;
import stepDefinitions.login.LoginTests;
import utils.Utils;

public class DeleteTests {
    private final WebDriver driver;
    private final Utils utils;

    public DeleteTests(){
        this.driver = LoginTests.getDriver();
        this.utils = new Utils(driver);
    }
    @When("user deletes his account")
    public void accountRemoval() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.removeTestData();
        verifyLogout();
    }

    @Then("account is deleted")
    public void verifyLogout() {
        utils.getWait(15).until(ExpectedConditions.urlContains("login"));
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Logout failed!");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
