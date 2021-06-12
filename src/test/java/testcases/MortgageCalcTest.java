package testcases;

import org.testng.annotations.Test;

import base.TestBase;
import page.MortgageCalcPage;

public class MortgageCalcTest extends TestBase {
 
    MortgageCalcPage calcPage; 

    @Test (description = "Mortgage Calculator Test")
    public void mortgageCalcTest(){
        calcPage = new MortgageCalcPage(getDriver());
        calcPage.enterHomeEval("450000");
        calcPage.enterdownPayment("75000");
    }  
}
