package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P3_ResetPassword;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.driver;

public class D3_ResetPasswordStepDef {
    P3_ResetPassword p3ResetPassword = new P3_ResetPassword();
    @And("user click on forgot password")
    public void forgotPassword(){

        p3ResetPassword.resetPassword().click();
    }
    @When("user enters his registered email")
    public void recoveremail(){

        p3ResetPassword.email().sendKeys("MohamedAhmed@gmail.com");
    }
    @And("press on Recover button")
    public void recoverbtn(){

        p3ResetPassword.recoverButton().click();
    }
    @Then("user should reset his password successfully")
    public void successreset(){
        String expRes = "Email with instructions has been sent to you.";
        String actRes = driver.findElement(By.className("content")).getText();
        Assert.assertTrue(actRes.contains(expRes));
    }


}
