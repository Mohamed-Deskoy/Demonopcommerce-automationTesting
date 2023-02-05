package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_ResetPassword;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.driver;

public class D03_ResetPasswordStepDef {

    P03_ResetPassword resetPassword = new P03_ResetPassword();

    @And("user click on forgot password")
    public void forgotPassword(){

        resetPassword.resetPassword().click();
    }

    @When("user enters his registered email")
    public void recoveremail(){

        resetPassword.email().sendKeys("MohamedAhmed@gmail.com");
    }

    @And("press on Recover button")
    public void recoverbtn(){

        resetPassword.recoverButton().click();
    }
    @Then("user should reset his password successfully")
    public void successreset(){
        String expectedResult = "Email with instructions has been sent to you.";
        String actualResult = driver.findElement(By.className("content")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }


}
