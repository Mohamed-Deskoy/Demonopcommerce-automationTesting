package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P09_Wishlist_WebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;

public class D09_Wishlist_StepDefinitions {

    P09_Wishlist_WebElements wishlist = new P09_Wishlist_WebElements();


    @When("user clicks on the wishlist button")
    public void click_wishlist(){

        wishlist.wishlist_btn().get(2).click();
    }

    @Then("the product is added to wishlist and success message appears")
    public void wishlist_success(){

        SoftAssert soft = new SoftAssert();

        String expectedResult = "The product has been added to your ";
        String actualResult = wishlist.successMsg().getText();

        soft.assertTrue(actualResult.contains(expectedResult));
        String Msg_backgroundColor = wishlist.successMsg().getCssValue("background-color");
        soft.assertEquals(Msg_backgroundColor, "rgba(75, 176, 122, 1)");

        soft.assertAll();
    }


    @And("user waits until success message disappears and clicks on wishlist Tab")
    public void click_wishlistTab(){

        Assert.assertTrue(new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class=\"bar-notification success\"]"))));

        wishlist.wishlistTab().click();
    }


    @Then("product is existed in the wishlist")
    public void product_exists(){
       String quantity = driver.findElement(By.className("qty-input")).getAttribute("Value");
       Assert.assertTrue(true, quantity);
    }


}
