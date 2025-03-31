package stepDefinitions.register;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.Utils;

import java.time.Duration;

public class RegistrationTests {
    private WebDriver driver;
    private RegistrationPage registrationPage;

    @Given("user is on the registration page")
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://monetis-delta.vercel.app/register");
        registrationPage = new RegistrationPage(driver);
    }

    @When("user attempts registration")
    public void testRegistration() {
        registrationPage.register(
                "Joao", "Lazaro", "johnlazaro12@gmail.com", "123 Street",
                "1234-567", "Lisbon", "Portugal", "SecurePWD#12"
        );
    }

    @Then("Registration is Validated")
    public void verifyRegistration() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("dashboard"));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("dashboard"), "Registration failed! Still on: " + currentUrl);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
