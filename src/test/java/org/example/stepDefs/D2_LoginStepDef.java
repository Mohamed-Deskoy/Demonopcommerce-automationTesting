package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.p2Login;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;


public class D2_LoginStepDef {

    org.example.pages.p2Login p2Login = new p2Login(driver);

    @Given("user goes to login page")
    public void loginPage(){
        p2Login.loginOption().click();
    }

    @When("user enters {string} and {string}")
    public void loginData(String email , String password){
        p2Login.loginOption().click();
        p2Login.email().clear();
        p2Login.email().sendKeys(email);
        p2Login.password().clear();
        p2Login.password().sendKeys(password);
    }
    @And("user click on login button")
    public void loginClick(){

        p2Login.password().sendKeys(Keys.ENTER);
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
        SoftAssert softAssert = new SoftAssert();
        String expRes = "Login was unsuccessful.";
        String actRes = driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]")).getText();
        softAssert.assertTrue(actRes.contains(expRes) , "there is an error in the second login scenario");
        String color = driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]")).getCssValue("color");
        System.out.println(color);
        softAssert.assertEquals(color, "rgba(228, 67, 75, 1)");
        softAssert.assertAll();
    }

}
