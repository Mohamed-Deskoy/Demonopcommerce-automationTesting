package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P5_SwitchCurrencies;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D5_SwitchCurrenciesStepDef {
    P5_SwitchCurrencies p5SwitchCurrencies = new P5_SwitchCurrencies();
    @When("user click on the currency selector and choose the US currency")
    public void usDollarSelection(){

        Select sel = new Select(p5SwitchCurrencies.currencySelector());
        sel.selectByVisibleText("US Dollar");
    }
    @Then("US dollar symbol is chosen and displayed on all products")
    public void usDollarChosenSuccessfully(){

        String expRes[] =new String[] {"$1,200.00" ,"$1,800.00" , "$245.00" , "$25.00"};

        for(int i = 0; i< p5SwitchCurrencies.pricesCurrency().size(); i++) {
            String actRes = p5SwitchCurrencies.pricesCurrency().get(i).getText();
            Assert.assertTrue(actRes.contains(expRes[i]));
                }
    }
    @When("user click on the currency selector and choose the Euro currency")
    public void euroSelection(){

        Select sel = new Select(p5SwitchCurrencies.currencySelector());
        sel.selectByVisibleText("Euro");
    }
    @Then("Euro symbol is chosen and displayed on all products")
    public void euroChosenSuccessfully(){

        String expRes[] =new String[] {"€1032.00" ,"€1548.00" , "€210.70" , "€21.50"};

        for(int i = 0; i< p5SwitchCurrencies.pricesCurrency().size(); i++) {

            String actRes = p5SwitchCurrencies.pricesCurrency().get(i).getText();

            Assert.assertTrue(actRes.contains(expRes[i]));
        }
    }

}
