package page;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLoginPage extends TestBase {

    // Page Factory
    public SauceDemoLoginPage(WebDriver driver){
        PageFactory.initElements(getDriver(), this);
    }

    // Element Locators: Id, Name, TagName, Xpath, CSS Selectors
    @FindBy(xpath = "//div//input[@id='user-name']")
    WebElement usernameInput;

    @FindBy(xpath = "//div//input[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//div//input[@id='login-button']")
    WebElement loginSubmit;

    // Methods/Functions

    // Enter Username
    public void enterUsername(String username){
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    // Enter Password
    public void enterPassword(String password){
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    // Login Submit
    public void loginButton(){
        loginSubmit.click();
    }
}
