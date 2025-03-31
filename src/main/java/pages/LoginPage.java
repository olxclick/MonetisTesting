package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;

public class LoginPage {
    private final Utils utils;

    private final By emailField = By.name("email");
    private final By passwordField = By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        utils = new Utils(driver);
    }

    public void enterEmail(String email) {
        utils.waitAndSendKeys(emailField, email);
    }

    public void enterPassword(String password) {
        utils.waitAndSendKeys(passwordField, password);
    }

    public void clickLogin() {
        utils.waitAndClick(loginButton);
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

}
