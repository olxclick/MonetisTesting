package register;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.Utils;

public class RegistrationTests {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private Utils utils;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://monetis-delta.vercel.app/register");
        utils = new Utils(driver);

        registrationPage = new RegistrationPage(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testRegistration() {
        registrationPage.register(
                "Joao", "Lazaro", "johnlazaro12@gmail.com", "123 Street",
                "1234-567", "Lisbon", "Portugal", "SecurePWD#12"
        );

        String expectedUrl = "https://monetis-delta.vercel.app/dashboard";
        utils.waitUrl(expectedUrl);
        String currentUrl = driver.getCurrentUrl();

//        utils.removeTestData();
        Assert.assertEquals(currentUrl, expectedUrl, "Registration failed!");
    }
}
