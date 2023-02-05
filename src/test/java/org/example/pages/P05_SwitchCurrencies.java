package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P05_SwitchCurrencies {


    public List<WebElement> prices_Currency(){
        List<WebElement> costCurrency = driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")); //[$1,200.00 ,$1,800.00 , $245.00 , $25.00]
        return costCurrency;
    }
    public WebElement euro_currency(){
        return driver.findElement(By.cssSelector("option[value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2Fsearch%3Fq%3DLenovo%2520Thinkpad%2520X1%2520Carbon%2520Laptop\"]"));
    }
    public WebElement usDollar_currency(){
        return driver.findElement(By.cssSelector("span[class=\"price actual-price\"]"));
    }
    public WebElement currency_Selector(){
        return driver.findElement(By.id("customerCurrency"));
    }


}
