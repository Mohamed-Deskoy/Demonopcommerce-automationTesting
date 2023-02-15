package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P1_register;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.driver;

public class D1_registerStepDef {
    P1_register p1Register =new P1_register(driver);
    @Given("user goes to register page")
    public void registerPage(){
        p1Register.registerOption().click();
    }

    @When("user enters valid data")
    public void validData() throws InterruptedException {

        p1Register.genderMale_Radio().click();

        Thread.sleep(1000);

        p1Register.firstName().sendKeys("Mohamed");
        p1Register.lastName().sendKeys("Ahmed");

        Thread.sleep(1000);


        Select sel = new Select(p1Register.birthDay());
        sel.selectByIndex(2);
        sel = new Select(p1Register.birthMonth());
        sel.selectByValue("5");
        sel = new Select(p1Register.birthYear());
        sel.selectByVisibleText("2001");
        Thread.sleep(1000);
        p1Register.email().sendKeys("MohamedAhmed@gmail.com");
        Thread.sleep(1000);
        p1Register.companyName().sendKeys("zagazig university");
        p1Register.newsLetterCheckBox().click();
        Thread.sleep(1000);
        p1Register.password().sendKeys("123456");
        p1Register.confirmPassword().sendKeys("123456");

        Thread.sleep(2000);
    }
    @And("user click on register option")
    public void registerClick() throws InterruptedException {
        p1Register.registerButton().click();
        Thread.sleep(3000);
    }

    @Then("user should register successfully")
    public void successfulRegistration(){
        Assert.assertTrue(driver.findElement(By.className("ico-logout")).isDisplayed() , "Assertion of SuccessfulRegistration error");
    }

    @And("registration completion message should appear")
    public void successMessage(){

        String expRes = "Your registration completed";
        String actRes = driver.findElement(By.cssSelector("div[class=\"result\"]")).getText();

        Assert.assertTrue(actRes.contains(expRes) , "Assertion of registration success message error");
    }



}
