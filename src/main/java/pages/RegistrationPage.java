package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Utils;

public class RegistrationPage {
    private final Utils utils;

    // 🔹 Define locators at the top for better readability & reusability
    private final By nameField = By.name("name");
    private final By surnameField = By.name("surname");
    private final By emailField = By.name("email");
    private final By streetAddressField = By.name("street_address");
    private final By postalCodeField = By.name("postal_code");
    private final By cityField = By.name("city");
    private final By countryDropdown = By.id("react-select-2-input");
    private final By passwordField = By.name("password");
    private final By confirmPasswordField = By.name("confirmPassword");
    private final By submitButton = By.xpath("//button[@type='submit']");

    // 🔹 Constructor
    public RegistrationPage(WebDriver driver) {
        this.utils = new Utils(driver);  // Pass the driver to utils
    }

    // 🔹 Methods to interact with elements
    public void enterName(String name) {
        utils.waitAndSendKeys(nameField, name);
    }

    public void enterSurname(String surname) {
        utils.waitAndSendKeys(surnameField, surname);
    }

    public void enterEmail(String email) {
        utils.waitAndSendKeys(emailField, email);
    }

    public void enterStreetAddress(String address) {
        utils.waitAndSendKeys(streetAddressField, address);
    }

    public void enterPostalCode(String postalCode) {
        utils.waitAndSendKeys(postalCodeField, postalCode);
    }

    public void enterCity(String city) {
        utils.waitAndSendKeys(cityField, city);
    }

    public void selectCountry(String country) {
        utils.selectDropdownOption("react-select-2-input", country);
    }

    public void enterPassword(String password) {
        utils.waitAndSendKeys(passwordField, password);
    }

    public void confirmPassword(String confirmPassword) {
        utils.waitAndSendKeys(confirmPasswordField, confirmPassword);
    }

    public void clickSubmit() {
        utils.waitAndClick(submitButton);
    }

    // 🔹 Combined method for full registration
    public void register(String name, String surname, String email, String address, String postalCode,
                         String city, String country, String password) {
        enterName(name);
        enterSurname(surname);
        enterEmail(email);
        enterStreetAddress(address);
        enterPostalCode(postalCode);
        enterCity(city);
        selectCountry(country);
        enterPassword(password);
        confirmPassword(password);
        clickSubmit();
    }
}
