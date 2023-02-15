package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;

public class P5_SwitchCurrencies {


    public List<WebElement> pricesCurrency(){
        List<WebElement> elements = driver.findElements(By.cssSelector("span[class=\"price actual-price\"]")); //[$1,200.00 ,$1,800.00 , $245.00 , $25.00]
        return elements;
    }
    public WebElement euroCurrency(){
        return driver.findElement(By.cssSelector("option[value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2Fsearch%3Fq%3DLenovo%2520Thinkpad%2520X1%2520Carbon%2520Laptop\"]"));
    }
    public WebElement usDollarCurrency(){
        return driver.findElement(By.cssSelector("span[class=\"price actual-price\"]"));
    }
    public WebElement currencySelector(){
        return driver.findElement(By.id("customerCurrency"));
    }


}
