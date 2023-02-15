package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.p2Login;
import org.example.pages.P4_ProductSearch;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.driver;

public class D4_ProductSearchStepDef {
    P4_ProductSearch p4ProductSearch = new P4_ProductSearch();
    org.example.pages.p2Login p2Login = new p2Login(driver);
    @When("user click on search box and write {string}")
    public void searchBox(String productName){

        p4ProductSearch.searchBox().sendKeys(productName);
    }
    @And("user press on the search button")
    public void searchButton(){

        p4ProductSearch.searchButton().click();
    }
    @Then("{string} should appear successfully")
    public void productfoundsuccess(String productName){
       Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));
        System.out.println("Number of search results is: " + p4ProductSearch.productsNamesList().size());
       for(int count = 0; count < p4ProductSearch.productsNamesList().size() ; count++) {
           Assert.assertTrue(p4ProductSearch.productsNamesList().get(count).getText().toLowerCase().contains(productName));
        }

    }
    @And("user click on the product in search result")
    public void clickonproduct(){

        driver.findElement(By.cssSelector("div[class=\"picture\"]")).click();
    }
    @Then("{string} should appear successfully in product page")
    public void serialnfound(String serialNumber){
        int count = 0;
        Assert.assertTrue(p4ProductSearch.serialNumbersList().get(count).getText().contains(serialNumber));
        count++;
    }
}
