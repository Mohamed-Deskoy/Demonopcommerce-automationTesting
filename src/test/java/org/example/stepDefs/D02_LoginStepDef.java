package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_Login;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;


public class D02_LoginStepDef {

    P02_Login login = new P02_Login(driver);

    @Given("user goes to login page")
    public void loginPage(){

        login.login_Option().click();
    }

    @When("user enters {string} and {string}")
    public void loginData(String email , String password){
        login.login_Option().click();
        login.email().clear();
        login.email().sendKeys(email);

        login.password().clear();
        login.password().sendKeys(password);
    }


    @And("user click on login button")
    public void loginClick(){

        login.password().sendKeys(Keys.ENTER);
    }


    @Then("user should be login successfully")
    public void successlogin(){

        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
    }
    @And("user go to the home page")
    public void homepage(){

        Assert.assertEquals("https://demo.nopcommerce.com/" , driver.getCurrentUrl());
        Assert.assertTrue(driver.findElement(By.className("ico-account")).isDisplayed());
    }
    @Then("user should not login successfully")
    public void failedLogin(){
        SoftAssert soft = new SoftAssert();
        String expectedResult = "Login was unsuccessful.";
        String actualResult = driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]")).getText();
        soft.assertTrue(actualResult.contains(expectedResult) , "there is an error in the second login scenario");
        String message_Color = driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]")).getCssValue("color");
        System.out.println(message_Color);
        soft.assertEquals(message_Color, "rgba(228, 67, 75, 1)");
        soft.assertAll();
    }

}
