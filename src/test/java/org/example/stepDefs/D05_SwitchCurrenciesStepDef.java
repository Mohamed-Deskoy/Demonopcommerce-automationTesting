package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P05_SwitchCurrencies;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D05_SwitchCurrenciesStepDef {

    P05_SwitchCurrencies currency = new P05_SwitchCurrencies();

    @When("user click on the currency selector and choose the US currency")
    public void usDollarSelection(){

        Select select = new Select(currency.currency_Selector());
        select.selectByVisibleText("US Dollar");
    }

    @Then("US dollar symbol is chosen and displayed on all products")
    public void usDollarChosenSuccessfully(){



        String expectedResult[] =new String[] {"$1,200.00" ,"$1,800.00" , "$245.00" , "$25.00"};

        for(int i=0; i<currency.prices_Currency().size(); i++) {
            String actualResult = currency.prices_Currency().get(i).getText();
            Assert.assertTrue(actualResult.contains(expectedResult[i]));
                }
    }



    @When("user click on the currency selector and choose the Euro currency")
    public void euroSelection(){

        Select select = new Select(currency.currency_Selector());
        select.selectByVisibleText("Euro");
    }


    @Then("Euro symbol is chosen and displayed on all products")
    public void euroChosenSuccessfully(){

        String expectedResult[] =new String[] {"€1032.00" ,"€1548.00" , "€210.70" , "€21.50"};

        for(int i=0; i<currency.prices_Currency().size(); i++) {

            String actualResult = currency.prices_Currency().get(i).getText();

            Assert.assertTrue(actualResult.contains(expectedResult[i]));
        }
    }



}
