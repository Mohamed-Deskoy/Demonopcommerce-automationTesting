package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.driver;

public class D01_registerStepDef {
    P01_register register=new P01_register(driver);
    @Given("user goes to register page")
    public void register_Page(){

        register.registerOption().click();
    }


    @When("user enters valid data")
    public void validData() throws InterruptedException {

        register.genderMale_Radio().click();

        Thread.sleep(1000);

        register.firstName().sendKeys("Mohamed");
        register.lastName().sendKeys("Ahmed");

        Thread.sleep(1000);


        Select select = new Select(register.birthDay());
        select.selectByIndex(2);

        select = new Select(register.birthMonth());
        select.selectByValue("5");

        select = new Select(register.birthYear());
        select.selectByVisibleText("2001");

        Thread.sleep(1000);

        register.email().sendKeys("MohamedAhmed@gmail.com");

        Thread.sleep(1000);

        register.companyName().sendKeys("zagazig university");
        register.newsLetterCheckBox().click();

        Thread.sleep(1000);

        register.password().sendKeys("123456");
        register.confirmPassword().sendKeys("123456");

        Thread.sleep(2000);
    }

    @And("user click on register option")
    public void registerClick() throws InterruptedException {
        register.registerButton().click();

        Thread.sleep(3000);
    }


    @Then("user should register successfully")
    public void successful_Registration(){
        Assert.assertTrue(driver.findElement(By.className("ico-logout")).isDisplayed() , "Assertion of SuccessfulRegistration error");
    }

    @And("registration completion message should appear")
    public void success_message(){

        String expectedResult = "Your registration completed";
        String actualResult = driver.findElement(By.cssSelector("div[class=\"result\"]")).getText();

        Assert.assertTrue(actualResult.contains(expectedResult) , "Assertion of registration success message error");
    }



}
