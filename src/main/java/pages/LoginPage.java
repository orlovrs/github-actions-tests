package pages;

import extensions.Driver;
import extensions.Element;
import models.users.UserCredentials;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {

    private Element usernameInput = new Element(How.ID, "user-name");
    private Element passwordInput = new Element(How.CSS, "#password");
    private Element loginButton = new Element(How.XPATH, "//input[@id='login-button']");
    private Element errorMessage = new Element(How.XPATH, "//h3[@data-test='error']");

    public LoginPage() {
        URL += "/";
    }

    public LoginPage open() {
        Driver.get().get(URL);
        return this;
    }

    public LoginPage fillUsernameInput(String s) {
        usernameInput.sendKeys(s);
        return this;
    }

    public LoginPage fillPasswordInput(String s) {
        passwordInput.sendKeys(s);
        return this;
    }

    public InventoryListPage clickLoginButton() {
        loginButton.click();
        return Pages.inventoryList;
    }

    public InventoryListPage loginUserSuccess(UserCredentials creds) {
        return fillUsernameInput(creds.getUsername())
                .fillPasswordInput(creds.getPassword())
                .clickLoginButton();
    }

    public LoginPage loginUserFailed(UserCredentials creds) {
        fillUsernameInput(creds.getUsername())
                .fillPasswordInput(creds.getPassword())
                .clickLoginButton();
        return this;
    }

    public LoginPage assertErrorMessagePresent() {
        assertTrue(errorMessage.isDisplayed());
        return this;
    }

    public LoginPage assertIsOnPage() {
        assertTrue(loginButton.isDisplayed());
        return this;
    }
}
