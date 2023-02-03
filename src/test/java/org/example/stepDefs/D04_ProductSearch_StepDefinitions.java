package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_Login_WebElements;
import org.example.pages.P04_ProductSearch_WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.driver;

public class D04_ProductSearch_StepDefinitions {

    P04_ProductSearch_WebElement productSearch = new P04_ProductSearch_WebElement();
    P02_Login_WebElements login = new P02_Login_WebElements(driver);


    @When("user click on search box and write {string}")
    public void searchBox(String productName){

        productSearch.search_Box().sendKeys(productName);
    }

    @And("user press on the search button")
    public void searchButton(){

        productSearch.search_Button().click();
    }


    @Then("{string} should appear successfully")
    public void productFoundSuccess(String productName){
       Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));

        System.out.println("Number of search results is: " + productSearch.productsNamesList().size());

       for(int i=0 ; i < productSearch.productsNamesList().size() ; i++) {
           Assert.assertTrue(productSearch.productsNamesList().get(i).getText().toLowerCase().contains(productName));
        }

    }


    @And("user click on the product in search result")
    public void clickOnProduct(){

        driver.findElement(By.cssSelector("div[class=\"picture\"]")).click();

    }


    @Then("{string} should appear successfully in product page")
    public void serialNFound(String serialNumber){

        int i = 0;
        Assert.assertTrue(productSearch.serialNumbersList().get(i).getText().contains(serialNumber));
        i++;
    }


}
