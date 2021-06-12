package page;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MortgageCalcPage extends TestBase {

// Page Factory
public MortgageCalcPage(WebDriver driver){
    PageFactory.initElements(driver, this);
}

//Element Locators: Id, Name, TagName, Xpath, CSS, Selectors
@FindBy(xpath = "//div/input[@id='homeval']")
WebElement homevalInput;

@FindBy(xpath = "//div/input[@id='downpayment']")
WebElement downPaymentInput;

@FindBy(xpath = "//div/input[@id='loanamt']")
WebElement loanamtInput;

@FindBy(xpath = "//div/input[@id='intrstsrate']")
WebElement intrstsrateInput;

@FindBy(xpath = "//div/input[@id='loanterm']")
WebElement loantermInput;

public void enterHomeEval(String homeEval) {
    homevalInput.sendKeys(homeEval);
} 

public void enterdownPayment(String downPayment) {
  downPaymentInput.sendKeys(downPayment);
}

public void selectStartDateDropdownMenu(String value){
    Select option = new Select(getDriver().findElement(By.xpath("")));
    // option.selectByIndex(1);
    option.selectByVisibleText(value);
}

/*
@FindBy(xpath = "//div/input[@id='  ']")
WebElement ;

@FindBy(xpath = "//div/input[@id='  ']")
WebElement ;

@FindBy(xpath = "//div/input[@id='  ']")
WebElement ;

@FindBy(xpath = "//div/input[@id='  ']")
WebElement ;

@FindBy(xpath = "//div/input[@id='  ']")
WebElement ;

@FindBy(xpath = "//div/input[@id='  ']")
WebElement ;

@FindBy(xpath = "//div/input[@id='  ']")
WebElement ;

@FindBy(xpath = "//div/input[@id='  ']")
WebElement ;
*/

}
