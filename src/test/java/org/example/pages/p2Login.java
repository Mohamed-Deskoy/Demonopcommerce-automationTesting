package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class p2Login {

    WebDriver driver = null;

    public p2Login(WebDriver driver){
        this.driver = driver;
    }
    public p2Login(){};
    public WebElement loginOption(){
        return driver.findElement(By.className("ico-login"));
    }
    public WebElement password(){
        return driver.findElement(By.id("Password"));
    }

    public WebElement email(){
        return driver.findElement(By.id("Email"));
    }}


