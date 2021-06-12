package testcases;

import base.TestBase;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.SauceDemoLoginPage;

public class SauceDemoLoginTest extends TestBase {

    // Logger
    public static final Logger log = Logger.getLogger(SauceDemoLoginTest.class.getName());

    // Sauce Demo Login Page
    SauceDemoLoginPage loginPage;

    @Test (description = "Sauce Demo Login Test", enabled = false)
    public void testLoginPage() {
        log.info("testLoginPage() Test Case Started");

        // Create new instance of Sauce Demo Login Class (Page Object)
        loginPage = new SauceDemoLoginPage(driver);

        // Enter Hard Coded Values
        // loginPage.enterUsername("standard_user");
        // loginPage.enterPassword("secret_sauce");

        // Enter Dynamic Values from Config Properties File
        loginPage.enterUsername(TestBase.prop.getProperty("username"));
        loginPage.enterPassword(TestBase.prop.getProperty("password"));
        loginPage.loginButton();

        // Parametrization of test data can be implemented if desired with @DataProvider annotation

        // TODO: Refactor Thread.sleep() w/ WebDriver Wait or Fluent Wait (Enhance Synchronization of Test)
        try{
            Thread.sleep(5000);
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        // Test against new landing page url
        // https://www.saucedemo.com/inventory.html
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        log.info("testLoginPage() Test Case Ended");
    }
}
