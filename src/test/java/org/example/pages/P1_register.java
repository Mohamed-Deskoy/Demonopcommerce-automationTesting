package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_register {
    WebDriver driver =null;

    public P1_register(WebDriver driver){
        this.driver = driver;
    }

    public WebElement registerOption(){
        return driver.findElement(By.className("ico-register"));
    }

    public WebElement genderMale_Radio(){
        return driver.findElement(By.id("gender-male"));
    }

    public WebElement firstName(){
        return driver.findElement(By.id("FirstName"));
    }

    public WebElement lastName(){
        return driver.findElement(By.id("LastName"));
    }

    public WebElement birthDay(){
        return driver.findElement(By.cssSelector("select[name=\"DateOfBirthDay\"]"));
    }

    public WebElement birthMonth(){
        return driver.findElement(By.cssSelector("select[name=\"DateOfBirthMonth\"]"));
    }

    public WebElement birthYear(){
        return driver.findElement(By.cssSelector("select[name=\"DateOfBirthYear\"]"));
    }


    public WebElement email(){
        return driver.findElement(By.id("Email"));
    }

    public WebElement companyName(){
        return driver.findElement(By.id("Company"));
    }


    public WebElement newsLetterCheckBox(){
        return driver.findElement(By.cssSelector("input[data-val-required=\"The Newsletter field is required.\"]"));
    }

    public WebElement password(){
        return driver.findElement(By.id("Password"));
    }

    public WebElement confirmPassword(){
        return driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement registerButton(){
        return driver.findElement(By.id("register-button"));
    }
}
