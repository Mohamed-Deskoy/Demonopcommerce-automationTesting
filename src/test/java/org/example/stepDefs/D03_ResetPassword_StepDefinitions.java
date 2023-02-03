package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_ResetPassword_WebElements;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.driver;

public class D03_ResetPassword_StepDefinitions {

    P03_ResetPassword_WebElements resetPassword = new P03_ResetPassword_WebElements();

    @And("user click on forgot password")
    public void forgotPassword(){

        resetPassword.resetPassword().click();
    }

    @When("user enters his registered email")
    public void recoverEmail(){

        resetPassword.email().sendKeys("MohamedAhmed@gmail.com");
    }

    @And("press on Recover button")
    public void recoverBtn(){

        resetPassword.recoverButton().click();
    }

    @Then("user should reset his password successfully")
    public void successReset(){

        String expectedResult = "Email with instructions has been sent to you.";
        String actualResult = driver.findElement(By.className("content")).getText();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }


}
