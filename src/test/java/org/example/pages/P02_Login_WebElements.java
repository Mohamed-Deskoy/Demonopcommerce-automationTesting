package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P02_Login_WebElements {

    WebDriver driver = null;

    public P02_Login_WebElements(WebDriver driver){
        this.driver = driver;
    }
    public P02_Login_WebElements(){};

    public WebElement login_Option(){
        return driver.findElement(By.className("ico-login"));
    }

    public WebElement email(){
        return driver.findElement(By.id("Email"));
    }

    public WebElement password(){
        return driver.findElement(By.id("Password"));
    }
}
