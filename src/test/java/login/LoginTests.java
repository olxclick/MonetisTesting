package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;

public class LoginTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private Utils utils;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://monetis-delta.vercel.app/login");
        loginPage = new LoginPage(driver);
        utils = new Utils(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLogin() {
        loginPage.login("johnlazaro12@gmail.com", "SecurePWD#12");
        verifyLogin();
    }

    public void verifyLogin() {
        String expectedUrl = "https://monetis-delta.vercel.app/dashboard";
        utils.waitUrl(expectedUrl);
        String currentUrl = driver.getCurrentUrl();

        if (expectedUrl.equals(currentUrl))
            utils.removeTestData();
        Assert.assertEquals(currentUrl, expectedUrl, "Login failed!");
    }
}
