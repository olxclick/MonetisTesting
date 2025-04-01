package stepDefinitions.login;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import java.time.Duration;

public class LoginSD {
    private static WebDriver driver;
    private LoginPage loginPage;

    public static WebDriver getDriver(){
        return driver;
    }

    @Given("User is in the login page")
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://monetis-delta.vercel.app/login");
        loginPage = new LoginPage(driver);
    }

    @When("user attempts login")
    public void testLogin() {
        loginPage.login("johnlazaro12@gmail.com", "SecurePWD#12");
        verifyLogin();
    }

    @Then("Login is Validated")
    public void verifyLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("dashboard"));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("dashboard"), "Login failed! Still on: " + currentUrl);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


